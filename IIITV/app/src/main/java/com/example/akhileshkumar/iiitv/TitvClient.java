package com.example.akhileshkumar.iiitv;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TitvClient {

	public static int port=0;
	public static void main(String []args)
	{
		String name;
		System.out.println("Enter the nick name : ");
		Scanner scn= new Scanner(System.in);
		name=scn.next();
		new Thread(new SelfListener()).start();
		try
		{
			Socket s=new Socket("localhost",5555);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			while(port==0)
			{
				Thread.sleep(1);
			}
			dout.writeUTF(name);
			dout.writeInt(port);
			dout.flush();
			while(true)
			{
				String write = scn.nextLine();
				System.out.println("Writing "+write);
				dout.writeUTF(write);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		scn.close();
	}
}