package com.od.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.od.dubbotest.api.HelloService;

@RestController
@RequestMapping(value="/bj")
public class BjAction {
	
	@Reference HelloService helloService;
	
	@RequestMapping
	public String say(String name) {
		System.out.println("HelloAction接收到请求:"+name);
		String str="<h1>这是Dubbo 消费者端(springboot)</h1>";
		str+="<h2>这里是北京站的页面</h2>";
        str+="<h2>这里是新加入的功能。。。</h2>";
		str+=helloService.hello(name);
		System.out.println("HelloService返回到结果:"+str);
		return str;
	}
}