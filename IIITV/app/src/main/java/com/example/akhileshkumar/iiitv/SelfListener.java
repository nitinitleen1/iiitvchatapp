package com.example.akhileshkumar.iiitv;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SelfListener implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String msg=null,clientfuck=null;
		System.out.println("Enter the port you want to listen on : ");
		Scanner scn = new Scanner(System.in);
		int port=scn.nextInt();
		TitvClient.port=port;
		try {
			ServerSocket ss = new ServerSocket(port);
			while(true)
			{
				Socket s = ss.accept();
				DataInputStream din = new DataInputStream(s.getInputStream());
				clientfuck=din.readUTF();
				msg=din.readUTF();
				System.out.println(clientfuck+" asshole said"+msg);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
