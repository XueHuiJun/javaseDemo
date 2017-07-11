package cn.itcast.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class UDPSend {

	public static void main(String[] args) throws IOException{
		// TODO 自动生成的方法存根
		//byte[] data = "你好UDP".getBytes();
		Scanner scanner = new Scanner(System.in);
		InetAddress inetAddress = InetAddress.getLocalHost();
		DatagramSocket datagramSocket = new DatagramSocket();
		while(true){
			byte[] data = scanner.nextLine().getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, 6000);
			datagramSocket.send(datagramPacket);
		}
		//datagramSocket.close();
	}

}
