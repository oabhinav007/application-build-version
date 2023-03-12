package zama.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StartWebApplication extends SpringBootServletInitializer {

    /*public static void main(String[] args) {
        SpringApplication.run(StartWebApplication.class, args);
        //System.out.println("args.length="+args.length);
        String version = args[0];
        //System.getenv("app.version");
        if (version == null || version.isEmpty()) {
            throw new IllegalArgumentException("Missing value for APP_VERSION");
        }
        System.out.println(version);
        
    }*/
    // public static void main(String[] args) {
    //     String buildNumber = System.getProperty("BUILD_NUMBER");
    //     System.out.println("Build number: " + buildNumber);
    //     // Use buildNumber in your program
    // }

    public static void main(String[] args) {
        String buildNumber = System.getenv("BUILD_NUMBER");
        System.out.println("Build number: " + buildNumber);

    }
    
    

    // @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        
    //     return builder.sources(StartWebApplication.class);
    // }
}