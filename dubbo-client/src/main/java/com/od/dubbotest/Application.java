package com.od.dubbotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import java.util.Date;

import com.od.dubbotest.action.HelloAction;

@ImportResource(value={"classpath*:spring-config.xml"})
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
    public static void main( String[] args) {
    	ApplicationContext context=SpringApplication.run("classpath*:spring-config.xml",args);
    	HelloAction action=(HelloAction) context.getBean("helloAction");
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	String ds = df.format(new Date());
        System.out.println(ds + "Dubbo client started");
        System.out.println(ds + "Dubbo 消费者端启动");
        //action.say("jack");
        //action.say("tom");
        //action.say("jim");
    }
}
