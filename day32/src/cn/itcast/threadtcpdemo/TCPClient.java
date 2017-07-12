package cn.itcast.threadtcpdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		InetAddress inetAddress = InetAddress.getLocalHost();
		Socket socket = new Socket(inetAddress,8811);
		OutputStream outputStream = socket.getOutputStream();
		File file = new File("C:\\Users\\xh\\Pictures\\Screenshots\\1.png");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] data = new byte[1024];
		int len = 0;
		while((len = fileInputStream.read(data))!=-1)
		{
			outputStream.write(data);
		}
		socket.shutdownOutput();
		if((len = socket.getInputStream().read(data))!=-1)
		{
			System.out.println(new String(data,0,len));
		}
		socket.close();
		fileInputStream.close();
	}

}
