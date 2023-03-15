package zama.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class StartWebApplication extends SpringBootServletInitializer {

  //  @Value("${build.number}")
    String buildNumber;

    public static void main(String[] args) {
        // SpringApplication.run(StartWebApplication.class, args);
        //System.out.println("args.length="+args.length);
        /*String buildNumber = System.getenv("BUILD_NUMBER");
        System.out.println(buildNumber);
        String version = args[0];
        //System.getenv("app.version");
        if (version == null || version.isEmpty()) {
            throw new IllegalArgumentException("Missing value for APP_VERSION");
        }
        System.out.println(version);
         */

        try (FileInputStream input = new FileInputStream("env.properties")) {
            Properties props = new Properties();
            props.load(input);
            String buildNumber = props.getProperty("BUILD_NUMBER");
            System.out.println("Latest build version is: " + buildNumber);
        } catch (IOException ex) {
            System.err.println("Unable to read environment properties: " + ex.getMessage());
        }
        
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        
        return builder.sources(StartWebApplication.class);
    }
}