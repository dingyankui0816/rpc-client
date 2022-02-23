package com.cn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        RpcProxyClient rpcProxyClient = new RpcProxyClient();
//        IHelloService iHelloService = rpcProxyClient.clientProxy(IHelloService.class,"localhost",8080);
//        String levi = iHelloService.sayHello("Levi");
//        System.out.println(levi);

        ApplicationContext context  = new AnnotationConfigApplicationContext(RpcConfig.class);
        RpcProxyClient rpcProxyClient = context.getBean(RpcProxyClient.class);
        IHelloService iHelloService = rpcProxyClient.clientProxy(IHelloService.class,"localhost",8080);
        String levi = iHelloService.sayHello("Levi");
        System.out.println(levi);
    }
}
