package hello.config;

import hello.json.Page;
import hello.service.FacebookLookupService;

import java.util.concurrent.Future;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration
//@PropertySource("/apps/conf/app.properties") //Use this instead of application.properties
@ComponentScan({"hello.service", "hello.controller"}) 


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
        long start = System.currentTimeMillis();
//
//        // Kick of multiple, asynchronous lookups
//        Future<Page> page1 = facebookLookupService.findPage("PivotalSoftware");
//        Future<Page> page2 = facebookLookupService.findPage("CloudFoundry");
//        Future<Page> page3 = facebookLookupService.findPage("SpringFramework");
//
//        // Wait until they are all done
//        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
//            Thread.sleep(10); //millisecond pause between each check
//        }

        // Print results, including elapsed time
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
//        System.out.println(page1.get().getName());
//        System.out.println(page2.get().getName());
//        System.out.println(page3.get().getName());
    }

}
