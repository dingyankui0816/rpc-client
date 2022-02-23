package com.cn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description todo
 * @Author: Levi.Ding
 * @Date: 2022/2/22 16:41
 * @Version V1.0
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");
        RcpRequest rcpRequest = new RcpRequest();
        rcpRequest.setClassName(method.getDeclaringClass().getName());
        rcpRequest.setMethodName(method.getName());
        rcpRequest.setParameters(args);
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,port);
        Object send = rpcNetTransport.send(rcpRequest);
        return send;
    }
}
