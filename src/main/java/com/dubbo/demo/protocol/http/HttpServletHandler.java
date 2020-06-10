package com.dubbo.demo.protocol.http;

import com.dubbo.demo.consumer.Invocation;
import com.dubbo.demo.register.local.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServletHandler {

    public void doHandler(ServletRequest req, ServletResponse res) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        InputStream inputStream = req.getInputStream();
        //获取读取到的参数
        Invocation invocation = (Invocation)new ObjectInputStream(inputStream).readObject();
        String interfaceName = invocation.getInterfaceName();
        //从本地注册列表获取服务
        Class serviceClass = LocalRegister.getService(interfaceName);
        if(serviceClass == null){
            throw new RuntimeException("服务未注册");
        }
        //获取需要调用的方法
        Method method = serviceClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        if(method == null){
            throw new RuntimeException("方法不存在");
        }
        String result = (String)method.invoke(serviceClass.newInstance(), invocation.getParams());
        //返回响应结果
        IOUtils.write(result, res.getOutputStream(), "utf-8");
    }
}
