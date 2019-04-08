package com.od.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.od.dubbotest.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;


@ApolloConfig
@RestController
@RequestMapping(value="/hello")
public class HelloAction {
	
	@Autowired HelloService helloService;
	
	@RequestMapping
	public String say(String name) {
		System.out.println("HelloAction接收到请求:"+name);
		String str="<h1>这是Dubbo 消费者端</h1>";
		str+=helloService.hello(name);
		System.out.println("HelloService返回到结果:"+str);
		return str;
	}
}
