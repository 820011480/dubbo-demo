package com.dubbo.demo.route;

import com.dubbo.demo.register.remote.Url;

public interface Rule {

    public Url doRule(String interfaceName);
}
