package cn.itcast.threadtcpdemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		ServerSocket serverSocket = new ServerSocket(8811);
		while(true)
		{
			Socket socket = serverSocket.accept();
			new Thread(new Upload(socket)).start();
		}
	}

}
