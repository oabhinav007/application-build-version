package zama.training.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Controller
public class WelcomeController {
    private static final Logger logger = LogManager.getLogger(WelcomeController.class);
    public static String FILE_LOCATION = "/usr/local/tomcat/build.txt";
    
    //"D:/app-build-version/application-build-version/src/main/java/zama/training/controller/build.txt";

	public static String PROPERTY_FILE_LOCATION = "/shared/dev.properties";
	
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
    public static void main(String[] args) {
        String buildNumber = new WelcomeController().readBuildNumber();
        //model.addAttribute("buildNumber", buildNumber);
    }
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        String s = readBuildNumber();
        System.out.println("hi" + s);
        model.addAttribute("num", "6");
        model.addAttribute("build", s);
        addParamsToModel(model);
        
        return "welcome"; //view
    }

    @GetMapping("/properties")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        addParamsToModel(model);
        
        return "properties";
    }

	private void addParamsToModel(Model model) {
		Properties prop = readPropertyFile();
        model.addAttribute("driverName", prop.get("driverName"));
        model.addAttribute("datasourceUrl", prop.get("datasourceUrl"));
        model.addAttribute("datasourceUserName", prop.get("datasourceUserName"));
        model.addAttribute("datasourcePassword", prop.get("datasourcePassword"));
	}
    
    private Properties readPropertyFile() {
    	Properties props = new Properties();
    	logger.info("Loading property file from: "+ PROPERTY_FILE_LOCATION);
    	try(FileInputStream fis = new FileInputStream(PROPERTY_FILE_LOCATION)){
    		props.load(fis);
    		logger.info("props: "+props);
    	} catch (FileNotFoundException e) {
    		logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
    	return props;
    }
    private String readBuildNumber() {
        System.out.println("&&&&&&&&&&&&&&777");
        String userDirectory = new File("").getAbsolutePath();
        System.out.println(userDirectory);
        String buildNumber = "";
        try (FileInputStream fis = new FileInputStream(FILE_LOCATION)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("BUILD_NUMBER=")) {

                    buildNumber = line.substring(13);
                    System.out.println(buildNumber);
                    break;
                }
            }
            reader.close();
        } catch (IOException e)
        {System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return buildNumber;
    }
}