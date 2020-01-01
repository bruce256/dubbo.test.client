package com.jd.lvsheng.dubbo.client.test;

import org.apache.dubbo.common.utils.NetUtils;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.dubbo.server.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("importService")
public class ImportService {
	
	@Autowired
	private RegistryConfig    registry;
	@Autowired
	private ApplicationConfig application;
	
	private ReferenceConfig<DemoService> newServiceConfig(String group) {
		ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>();
		reference.setApplication(application);
		reference.setRegistry(registry);
		reference.setInterface(DemoService.class);
		reference.setGroup(group);
		return reference;
	}
	
	public void port() {
		ReferenceConfig<DemoService> service = newServiceConfig("IM-CELL-ACCESS-" + NetUtils.getLocalAddress().getHostAddress() + "-"
																		+ "25000");
		DemoService ds = service.get();
		System.out.println(ds.sayHello("ls"));
		
	}
}
