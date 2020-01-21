package com.jd.lvsheng.dubbo.client.test;

import org.dubbo.server.api.DemoService;

/**
 * @author LvSheng
 * @date 2020/1/17
 **/
public class DemoServiceStub implements DemoService {
	
	private DemoService remoteDemoService;
	
	public DemoServiceStub(DemoService remoteDemoService) {
		this.remoteDemoService = remoteDemoService;
	}
	
	public String sayHello(String s) {
		if ("admin".equals(s)) {
			return "administer";
		}
		return remoteDemoService.sayHello(s);
	}
}
