package cn.itcast.uploaddemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO 自动生成的方法存根
		InetAddress inetAddress = InetAddress.getLocalHost();
		Socket socket = new Socket(inetAddress, 8800);
		OutputStream outputStream = socket.getOutputStream();
		
		
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\xh\\Pictures\\Screenshots\\1.png");
		byte[] data = new byte[1024]; 
		int len = 0;
		while((len = fileInputStream.read(data))!=-1)
		{
			outputStream.write(data,0,len);
		}
		socket.shutdownOutput();
		
		InputStream in = socket.getInputStream();
		len = in.read(data);
		System.out.println(new String(data,0,len));
		
		fileInputStream.close();
		socket.close();
	}

}
