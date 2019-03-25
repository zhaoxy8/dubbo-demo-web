package com.zl.dubbotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.zl.dubbotest.action.HelloAction;

@SpringBootApplication
public class Application {
    public static void main( String[] args) {
    	ApplicationContext context=SpringApplication.run("classpath*:spring-config.xml",args);
    	HelloAction action=(HelloAction) context.getBean("helloAction");
        System.out.println("Dubbo client started");
        action.say("jack");
        action.say("tom");
        action.say("jim");
    }
}