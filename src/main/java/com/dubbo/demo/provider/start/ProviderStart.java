package com.dubbo.demo.provider.start;

import com.dubbo.demo.protocol.http.HttpServer;
import com.dubbo.demo.provider.service.HelloService;
import com.dubbo.demo.register.local.LocalRegister;
import com.dubbo.demo.register.remote.RemoteRegister;
import com.dubbo.demo.register.remote.Url;

public class ProviderStart {

    public static void main(String[] args) {
        //1.本地注册服务{服务名：接口}
        LocalRegister.addService("helloService", HelloService.class);
        //2.远程注册服务{服务名：List<Url>远程服务地址}
        RemoteRegister.addService("helloService", new Url("127.0.0.1", 8080));
        //3.启动服务
        HttpServer.start("provider-demo", 8080);
    }
}
