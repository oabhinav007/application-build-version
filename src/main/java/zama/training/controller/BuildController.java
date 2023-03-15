package zama.training.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuildController {
    public static String FILE_LOCATION = "D:/app-build-version/application-build-version/build.txt";

    @GetMapping("/build")
    public String getBuild(Model model) {
       String buildNumber = readBuildNumber();
        model.addAttribute("buildNumber", buildNumber);
     //   System.out.println("...................."+buildNumber);
        addParamsToModel(model);
        return "build";
    }

    private void addParamsToModel(Model model) {
		
	}
    public static void main(String[] args) {
        String buildNumber = new BuildController().readBuildNumber();
        //model.addAttribute("buildNumber", buildNumber);
    }
    private String readBuildNumber() {
        System.out.println("&&&&&&&&&&&&&&777");
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
        {System.out.println("error");}
        return buildNumber;
    }
}