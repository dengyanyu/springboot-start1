package com.baidu;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
       /* ApplicationContext ctx = */
    	SpringApplication.run(Application.class, args);
        System.out.println("springboot启动成功");
//        System.out.println("springboot提供的bean有:");
       /* String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/
    }

}
