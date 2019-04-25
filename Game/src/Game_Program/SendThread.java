package Game_Program;

import Connection.ClientProgram;
import Connection.Player;

public class SendThread extends Thread{
	ClientProgram channel;
	Player player;
	
	public SendThread(ClientProgram channel, Player player) {
		this.channel = channel;
		this.player = player;
	}
	@Override
	public void run() {
		channel.send(player);
	}
}
