package com.dubbo.demo.register.local;

import java.util.HashMap;
import java.util.Map;

public class LocalRegister {
    /**
     * 本地注册表{服务名称：接口名称}
     */
    public static Map<String, Class> localMap = new HashMap<>();

    /**
     * 注册服务
     * @param serviceName
     * @param interfaceName
     */
    public static void addService(String serviceName, Class interfaceName){
        localMap.put(serviceName, interfaceName);
    }

    /**
     * 注册服务
     * @param serviceMap
     */
    public static void addServiceByMap(Map<String, Class> serviceMap){
        localMap.putAll(serviceMap);
    }

    /**
     * 获取服务
     * @param serviceName
     * @return
     */
    public static Class getService(String serviceName){
        return localMap.get(serviceName);
    }

    /**
     * 移除服务
     * @param serviceName
     */
    public static void removeService(String serviceName){
        localMap.remove(serviceName);
    }

    /**
     * 清空服务
     */
    public static void clearService(){
        localMap.clear();
    }
}
