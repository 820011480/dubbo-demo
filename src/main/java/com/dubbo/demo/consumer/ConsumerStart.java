package com.dubbo.demo.consumer;

import com.dubbo.demo.protocol.http.HttpClient;
import com.dubbo.demo.provider.service.HelloService;
import com.dubbo.demo.register.remote.Url;

import java.io.IOException;

public class ConsumerStart {

    //服务调用

    /**
     * 服务调用 正常的时使用动态代理进行服务调用
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = new HttpClient();
        Url url = new Url();
        url.setHostName("127.0.0.1");
        url.setPort(8080);
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"小马同学"});
        String result = httpClient.send(url, invocation);
        System.out.println(result);
    }
}
