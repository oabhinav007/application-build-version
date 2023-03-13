package zama.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StartWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
    String buildVersion = System.getenv("BUILD_NUMBER");
    if (buildVersion == null || buildVersion.isEmpty()) {
        throw new IllegalArgumentException("Missing value for BUILD_NUMBER");
    }
    System.out.println("Build version: " + buildVersion);

    SpringApplication.run(StartWebApplication.class, args);
}


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        
        return builder.sources(StartWebApplication.class);
    }
}