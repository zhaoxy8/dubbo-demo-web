package com.od.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.od.dubbotest.api.BjService;

@RestController
@RequestMapping(value="/bj")
public class BjAction {
	
	@Reference BjService bjService;
	
	@RequestMapping
	public String say(String name) {
		System.out.println("BjAction接收到请求:"+name);
		String str="<h1>这是Dubbo 消费者端(springboot)</h1>";
		str+="<h2>这里是北京站</h2>";
		str+=bjService.hello(name);
		System.out.println("BjService返回到结果:"+str);
		return str;
	}
}