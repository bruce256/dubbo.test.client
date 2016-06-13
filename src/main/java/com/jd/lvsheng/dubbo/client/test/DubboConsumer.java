package com.jd.lvsheng.dubbo.client.test;

import org.dubbo.server.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("dubboConsumer")
public class DubboConsumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		context.start();
		DemoService demoService = context.getBean("demoService", DemoService.class);
		System.out.println(demoService.sayHello("aaa"));
		System.in.read();
	}
}
