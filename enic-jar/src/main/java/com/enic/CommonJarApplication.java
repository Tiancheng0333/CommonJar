package com.enic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.enic.*")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class CommonJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonJarApplication.class, args);
    }

}
