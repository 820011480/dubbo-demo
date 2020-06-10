package com.dubbo.demo.register.remote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 远程服务注册
 */
public class RemoteRegister {

    /**
     * 本地注册表{服务名称：List<Url>}
     */
    public static Map<String, List<Url>> remoteMap = new HashMap<>();

    /**
     * 注册服务
     * @param serviceName
     * @param url
     */
    public static void addService(String serviceName, Url url){
        List<Url> urls = remoteMap.get(serviceName);
        urls.add(url);
        remoteMap.put(serviceName, urls);
    }

    /**
     * 注册服务
     * @param serviceMap
     */
    public static void addServiceByMap(Map<String, List<Url>> serviceMap){
        remoteMap.putAll(serviceMap);
    }

    /**
     * 获取服务
     * @param serviceName
     * @return
     */
    public static List<Url> getService(String serviceName){
        return remoteMap.get(serviceName);
    }

    /**
     * 移除服务
     * @param serviceName
     */
    public static void removeService(String serviceName){
        remoteMap.remove(serviceName);
    }

    /**
     * 清空服务
     */
    public static void clearService(){
        remoteMap.clear();
    }
}
