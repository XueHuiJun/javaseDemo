package cn.itcast.uploaddemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.Random;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		ServerSocket serverSocket = new ServerSocket(8800);
		Socket socket = serverSocket.accept();
		InputStream inputStream = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = 0;
		
		File file = new File("C:\\Users\\xh\\Pictures\\Screenshots\\服务器图片存放区");
		String fileName = "itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".png";
		FileOutputStream fileOutputStream = new FileOutputStream(file+File.separator+fileName);
		if(!file.exists())
		{
			file.mkdirs();
		}
		while((len = inputStream.read(data))!=-1)
		{
			fileOutputStream.write(data, 0, len);
		}
		
		socket.getOutputStream().write("已上传至服务器！".getBytes());
		
		fileOutputStream.close();
		serverSocket.close();
		socket.close();
	}

}
