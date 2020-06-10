package com.dubbo.demo.provider.service.impl;

import com.dubbo.demo.provider.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String username) {
        return "hello" + username;
    }
}
