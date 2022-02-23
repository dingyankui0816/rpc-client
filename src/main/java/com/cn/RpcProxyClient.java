package com.cn;


import java.lang.reflect.Proxy;

/**
 * @Description RpcProxyClient
 * @Author: Levi.Ding
 * @Date: 2022/2/22 16:39
 * @Version V1.0
 */
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
       return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),new Class[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }
}
