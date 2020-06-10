package com.dubbo.demo.register.remote;

/**
 * 远程地址对象
 */
public class Url {

    private String hostName;

    private Integer port;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Url() {}

    public Url(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    @Override
    public String toString() {
        return "Url{" +
                "hostName='" + hostName + '\'' +
                ", port=" + port +
                '}';
    }
}
