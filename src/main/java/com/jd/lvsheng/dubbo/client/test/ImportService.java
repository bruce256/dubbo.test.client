package com.jd.lvsheng.dubbo.client.test;

import org.apache.dubbo.common.utils.NetUtils;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.dubbo.server.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("importService")
public class ImportService {

    @Autowired
    private RegistryConfig    registry;
    @Autowired
    private ApplicationConfig application;

    private ReferenceConfig<DemoService> newReferenceConfig(String group) {
        ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface(DemoService.class);
        reference.setGroup(group);
        return reference;
    }

    public void port() {
        ReferenceConfig<DemoService> reference =
            newReferenceConfig("IM-CELL-ACCESS-" + NetUtils.getLocalAddress().getHostAddress() + "-"
                + "25000");
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
		// cache.get方法中会缓存 Reference对象，并且调用ReferenceConfig.get方法启动ReferenceConfig
        DemoService xxxService = cache.get(reference);
        System.out.println(xxxService.sayHello("ls"));

    }
}
