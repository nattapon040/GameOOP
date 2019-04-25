package Connection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;


import Game_Program.MultiPlayer_Control;
import Game_Program.Single_Control;
import Utility_Share.Utility_Share;

public class Channel implements Runnable{
	
	private Socket socket;
	private boolean running;
	
	private OnSocketListener onSocketListener;
	
	public Channel(Socket socket, OnSocketListener onSocketListener){
		
		Utility_Share.isConnect =true;
		this.socket = socket;
		this.onSocketListener = onSocketListener;
		
	}
	
	public void start(){
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void stop() throws IOException{
		running = false;
		socket.close();
	}
	
	@Override
	public void run(){
		running = true;
		while(running) {
			try {
				byte [] serialVersionIID = new byte[4096];
				InputStream inputStream = socket.getInputStream();
				inputStream.read(serialVersionIID);
				ByteArrayInputStream byteArr_InputStream = new ByteArrayInputStream(serialVersionIID);
				ObjectInputStream obj_InputStream = new ObjectInputStream(byteArr_InputStream);
				
				Player  player = (Player) obj_InputStream.readObject();
				
				if(player.getKey_User().equals(Single_Control.KeyUser)) {
					
					Utility_Share.player.setBlood(player.getBlood());
					
					System.out.println(Utility_Share.player.getBlood()+" Blood");
					continue;
				}
				
				if(Utility_Share.MultiPlayer.containsKey(player.getKey_User())) {
						Utility_Share.MultiPlayer.get(player.getKey_User()).setBlood(player.getBlood());
						Utility_Share.MultiPlayer.get(player.getKey_User()).setSpeedX(player.getSpeedX());
						Utility_Share.MultiPlayer.get(player.getKey_User()).setSpeedY(player.getSpeedY());
								
						Utility_Share.MultiPlayer.get(player.getKey_User()).setX(player.getX());
						Utility_Share.MultiPlayer.get(player.getKey_User()).setY(player.getY());
								
						Utility_Share.MultiPlayer.get(player.getKey_User()).updateSpeed();
				}else {
					
						MultiPlayer_Control control = new MultiPlayer_Control(player);
						Utility_Share.MultiPlayer.put(player.getKey_User(), control);
						
				}
				
				//if(null != onSocketListener)onSocketListener.onReceived(this, player);
		
			} catch (ClassNotFoundException | IOException e) {
				break;
			}
			
		}
		
	}
	
	
	public void sendData(Player object){
		PrintStream dataOut = null;
		byte [] serializedObject_Writer = new byte[4096];
		
		ByteArrayOutputStream byteArr_Obj = new ByteArrayOutputStream();
		ObjectOutputStream objectOutput = null;
		
		try {
			objectOutput = new ObjectOutputStream(byteArr_Obj);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			objectOutput.writeObject(object);
			objectOutput.flush();
			try {
				dataOut = new PrintStream(socket.getOutputStream());
			} catch (IOException e) {e.printStackTrace();}
			serializedObject_Writer = byteArr_Obj.toByteArray();
			dataOut = new PrintStream(socket.getOutputStream());
			dataOut.write(serializedObject_Writer);
			dataOut.flush();
			
		} catch (IOException e) {
			try {
				stop();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			dataOut.close();
			e.printStackTrace();
		
		}
	}
	

	public Socket getSocket(){
		return socket;
	}
}
