package cn.itcast.tcpdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();
		InputStream inputStream = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = inputStream.read(data);
		System.out.println(new String(data,0,len));
		
		OutputStream outputStream = socket.getOutputStream();
		byte[] data2 = "服务器已收到".getBytes();
		outputStream.write(data2);
		socket.close();
		serverSocket.close();
	}

}
