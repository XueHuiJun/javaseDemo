package cn.itcast.tcpdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		InetAddress inetAddress = InetAddress.getLocalHost();
		Socket socket = new Socket(inetAddress, 8888);
		OutputStream outputStream = socket.getOutputStream();
		byte[] data = "你好呀服务器".getBytes();
		outputStream.write(data);
		
		
		InputStream inputStream = socket.getInputStream();
		byte[] return_data = new byte[1024];
		int len = inputStream.read(return_data);
		System.out.println(new String(return_data,0,len));
		outputStream.close();
	}

}
