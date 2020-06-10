package com.dubbo.demo.consumer.proxy;


import com.dubbo.demo.consumer.Invocation;
import com.dubbo.demo.protocol.http.HttpClient;
import com.dubbo.demo.provider.service.HelloService;
import com.dubbo.demo.register.remote.RemoteRegister;
import com.dubbo.demo.register.remote.Url;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理工场
 */
public class ProxyFactory {

    public static <T> T getInterfaceProxy(Class<T>  interfaceClazz){

        return (T) Proxy.newProxyInstance(interfaceClazz.getClassLoader(), interfaceClazz.getClasses(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();
                //获取地址:
                Url url = RemoteRegister.getService(interfaceClazz.getName());
                Invocation invocation = new Invocation(interfaceClazz.getName(), method.getName(), method.getParameterTypes(), args);
                String result = httpClient.send(url, invocation);
                return result;
            }
        });
    }
}
