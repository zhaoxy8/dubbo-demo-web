package com.zl.dubboclient;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HelloTest {

	private URL url;
	private RestTemplate rest;

	@Before
	public void setUp() throws Exception {
		this.url = new URL("http://localhost:9090/hello?name={name}");
		rest = new TestRestTemplate();
	}

	@Test
	public void getHello() throws Exception {
		
		Map<String,String> params=new HashMap<String,String>();
		params.put("p1","<h1>这是一个标题</h1>");
		params.put("name", "dubbo");
		ResponseEntity<String> response = rest.getForEntity(url.toString(), String.class,params);
		assertThat(response.getBody(), equalTo("hello "+"dubbo"));
	}
}
