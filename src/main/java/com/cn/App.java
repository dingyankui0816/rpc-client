package com.cn;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService iHelloService = rpcProxyClient.clientProxy(IHelloService.class,"localhost",8080);
        String levi = iHelloService.sayHello("Levi");
        System.out.println(levi);
    }
}
