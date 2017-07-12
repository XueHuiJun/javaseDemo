package cn.itcast.threadtcpdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.Random;

public class Upload implements Runnable{
	private Socket socket;
	public Upload(){}
	public Upload(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		try
		{
		InputStream inputStream = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = 0;
		File file = new File("C:\\Users\\xh\\Pictures\\Screenshots\\服务器图片存放区");
		String fileName = "itcast"+System.currentTimeMillis()+new Random().nextInt(999999);
	    FileOutputStream fileOutputStream = new FileOutputStream(file+file.separator+fileName);
		if(!file.exists())
		{
			file.mkdirs();
		}
		while((len = inputStream.read(data))!=-1)
		{
			fileOutputStream.write(data);
		}
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("上传服务器成功！".getBytes());
		fileOutputStream.close();
		socket.close();
		outputStream.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("上传失败！");
		}
        
	}
}
