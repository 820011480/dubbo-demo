//package com.dubbo.demo.consumer;
//
//import com.dubbo.demo.consumer.proxy.ProxyFactory;
//import com.dubbo.demo.protocol.http.HttpClient;
//import com.dubbo.demo.provider.service.HelloService;
//import com.dubbo.demo.register.remote.Url;
//
//import java.io.IOException;
//
//public class ConsumerStart {
//
//    //服务调用
//
//    /**
//     * 服务调用 正常的时使用动态代理进行服务调用
//     * @param args
//     * @throws IOException
//     */
//    public static void main(String[] args) throws IOException {
//        HelloService helloService = ProxyFactory.getInterfaceProxy(HelloService.class);
//        System.out.println(helloService.sayHello("小马同学"));
//    }
//}
