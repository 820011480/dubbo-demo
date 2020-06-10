package com.dubbo.demo.route.impl;

import com.dubbo.demo.register.remote.RemoteRegister;
import com.dubbo.demo.register.remote.Url;
import com.dubbo.demo.route.Rule;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomRule implements Rule {

    //获取远程注册列表
   private Map<String, List<Url>> remoteRegister = RemoteRegister.remoteMap;

    @Override
    public Url doRule(String interfaceName) {
        List<Url> urlList = remoteRegister.get(interfaceName);
        //生成随机数
        return urlList.get(new Random().nextInt(urlList.size()));
    }
}
