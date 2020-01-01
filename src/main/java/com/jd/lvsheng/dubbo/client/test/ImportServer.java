package com.jd.lvsheng.dubbo.client.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ImportServer {
	public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        context.start();
        ImportService importService = context.getBean("importService", ImportService.class);
        importService.port();
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }  
}
