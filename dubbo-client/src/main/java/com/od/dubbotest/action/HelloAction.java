package com.od.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.od.dubbotest.api.HelloService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/hello")
public class HelloAction {
	
	@Reference HelloService helloService;
	
	@RequestMapping
	public String say(String name) {
	        Logger logger = Logger.getLogger("com");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String ds = df.format(new Date());
                logger.log(Level.INFO, "HelloAction接收到请求:{0}", name);
		String str = ds + "<h1>这是Dubbo 消费者端(Apollo)</h1><h2>o(*￣︶￣*)o欢迎来到老男孩教育K8S容器云架构师专题课1期。</h2>";
		str+=helloService.hello(name);
                logger.log(Level.INFO, "HelloService返回到结果:{0}", str);
		return str;
	}
}
