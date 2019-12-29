package com.od.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.od.dubbotest.api.HelloService;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value="/hello")
public class HelloAction {
	
	@Reference HelloService helloService;
	
	@RequestMapping
	public String say(String name) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String ds = df.format(new Date());
		System.out.println(ds + "HelloAction接收到请求:"+name);
		String str = ds + "<h1>这是Dubbo 消费者端(Tomcat服务)</h1>";
        str += "<h2>欢迎来到老男孩教育K8S容器云架构师专题课培训班1期。</h2>";
		str += helloService.hello(name);
		System.out.println(ds + "HelloService返回到结果:"+str);
		return str;
	}
}
