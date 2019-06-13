package com.od.dubbotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.od.dubbotest.action.HelloAction;
import com.od.dubbotest.action.BjAction;

@SpringBootApplication
public class Application {
    public static void main( String[] args) {
    	ApplicationContext context=SpringApplication.run("classpath*:spring-config.xml",args);
    	HelloAction action=(HelloAction) context.getBean("helloAction");
        BjAction bjAction=(BjAction) context.getBean("bjAction");
        System.out.println("Dubbo client started");
        System.out.println("Dubbo 消费者端启动");
        //action.say("jack");
        //action.say("tom");
        //action.say("jim");
    }
}