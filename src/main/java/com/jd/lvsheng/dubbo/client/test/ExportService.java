package com.jd.lvsheng.dubbo.client.test;

import org.dubbo.server.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Service("exportService")
public class ExportService {

	@Autowired private RegistryConfig		registry;
	@Autowired private ProtocolConfig		protocol;
	@Autowired private ApplicationConfig	application;

	private ReferenceConfig<DemoService> newServiceConfig(String group) {
		ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); 
		reference.setApplication(application);
		reference.setRegistry(registry);
		reference.setInterface(DemoService.class);
		reference.setGroup(group);
		return reference;
	}

	public void export() {
		ReferenceConfig<DemoService> service = newServiceConfig("IM-CELL-ACCESS-" + NetUtils.getLocalAddress().getHostAddress() + "-"
				+ "25000");
		DemoService ds = service.get();
		System.out.println(ds.sayHello("ls"));
	
	}
}
