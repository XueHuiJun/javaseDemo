package cn.itcast.demo;
import java.net.*;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException{
		// TODO 自动生成的方法存根
		
		function_1();
	}
	
	public static void function() throws UnknownHostException
	{
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println(inetAddress);
		
		String hostName = inetAddress.getHostName();
		String hostAddress = inetAddress.getHostAddress();
		
		System.out.println(hostName+"     "+hostAddress);
	}
	
	public static void function_1() throws UnknownHostException
	{
		InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
		String hostName = inetAddress.getHostName();
		String hostAddress = inetAddress.getHostAddress();
		System.out.println(hostName+"    "+hostAddress);
	}

}
