package com.od.dubbotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.od.dubbotest.action.HelloAction;


@EnableApolloConfig
@HelloService
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
    public static void main( String[] args) {
    	ApplicationContext context=SpringApplication.run("classpath*:spring-config.xml",args);
    	HelloAction action=(HelloAction) context.getBean("helloAction");
        System.out.println("Dubbo client started");
        System.out.println("Dubbo 消费者端启动");
        //action.say("jack");
        //action.say("tom");
        //action.say("jim");
    }
}
