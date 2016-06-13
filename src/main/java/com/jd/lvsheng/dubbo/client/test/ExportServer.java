package com.jd.lvsheng.dubbo.client.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ExportServer {
	public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});  
        context.start();  
        ExportService exportService = context.getBean("exportService", ExportService.class);
        exportService.export();
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟  
    }  
}
