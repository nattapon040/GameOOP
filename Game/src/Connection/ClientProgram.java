package Connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Utility_Share.Utility_Share;

public class ClientProgram implements OnSocketListener
{
	
	public Thread sendThread;
	
	public ClientProgram() {
		sendThread = new Thread();
	}
	@Override
	public void onConnected(Channel channel)
	{
		System.out.println("Connected.");
	}
	
	@Override
	public void onDisconnected(Channel channel)
	{
		System.out.println("Disconnected.");
	}
	
	@Override
	public void onReceived(Channel channel, Player msg)
	{
		System.out.println(msg);
	}

	public Channel channel ;
	public String ip = "";
	public void start() throws UnknownHostException, IOException
	{
		Scanner scanner = new Scanner(System.in);
		
		ClientResponse response = new ClientResponse();
		while(ip.isEmpty()) {
				ip = response.Response();
				System.out.println(ip);
		
		}
		Utility_Share.isConnect = true;
			

		
		System.out.println(ip);
		System.out.print("Port : ");
		int port = 61533;
		
		Socket socket = new Socket(ip, port);
		System.out.println("Connected");
		
		// Receive
		channel = new Channel(socket, this);
		channel.start();
		
		
		
		//scanner.close();
	//	channel.stop();
	
	}

	/*public static void main(String[] args) throws UnknownHostException, IOException
	{
		ClientProgram program = new ClientProgram();
		program.start();
	}*/
	
	
	
	public void send(Player object) {
		//channel.send(object);
	}
	
	
	
}
