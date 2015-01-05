package hello.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 
 * @author husaind
 * 
 * mvn spring-boot:run
 * 
 * http://localhost:8080/create?name=husain&email=husain@gmail
 */

@Configuration
@EnableAutoConfiguration
//@PropertySource("/apps/conf/app.properties") //Use this instead of application.properties
@ComponentScan({"hello.service", "hello.controller", "hello.config"}) 

@EnableJpaRepositories("hello.repo") //not really needed after AutoConfiguration
@EntityScan("hello.model") //not really needed after AutoConfiguration

@EnableAsync
@EnableScheduling
@EnableMBeanExport //default

public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    //TEST
    @Override
    public void run(String... args) throws Exception {
        // Start the clock
//        long start = System.currentTimeMillis();
//
//        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
    }

}
