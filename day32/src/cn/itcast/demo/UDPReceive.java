package cn.itcast.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {
	public static void main(String[] args) throws IOException{
		byte[] receiveData = new byte[1024*64];
		DatagramPacket datagramPacket = new DatagramPacket(receiveData, receiveData.length);
		DatagramSocket datagramSocket = new DatagramSocket(6000);
		while(true)
		{
			datagramSocket.receive(datagramPacket);
			int length = datagramPacket.getLength();
			System.out.println(new String(receiveData,0,length));
			String ip = datagramPacket.getAddress().getHostAddress();
			int port = datagramPacket.getPort();
			System.out.println(ip+"   "+port);
		}
		//datagramSocket.close();
	}
	
}
