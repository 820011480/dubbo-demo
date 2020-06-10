package com.dubbo.demo.protocol.http;

import com.dubbo.demo.consumer.Invocation;
import com.dubbo.demo.register.remote.Url;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    /**
     * 消费者需要通过Http客户端调用
     *
     * @return
     */
    public String send(Url myUrl, Invocation invocation) throws IOException {
        URL httpUrl = new URL("http", myUrl.getHostName(), myUrl.getPort(), "/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        httpURLConnection.setRequestMethod("post");
        //需要返回数据
        httpURLConnection.setDoOutput(true);
        //发送数据
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(httpURLConnection.getOutputStream());
        objectOutputStream.writeObject(invocation);
        objectOutputStream.flush();
        objectOutputStream.close();
        //接收返回值
        InputStream inputStream = httpURLConnection.getInputStream();
        //读取字节
        String result = IOUtils.toString(inputStream, "utf-8");
        return result;
    }
}
