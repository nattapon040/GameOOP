package Game_Program;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import Connection.Player;
import Utility_Share.Utility_Share;

public class MultiPlayer_Control extends JLabel implements ActionListener{
	
	private int x,y;
	private int speedX=0,speedY=0;
	private Player player;
	
	private Timer timer;
	private boolean addToFrame = false;
	private String keyUser;
	
	public MultiPlayer_Control(Player player) {
		timer = new Timer(1, this);
		timer.start();
		
		this.player =player;
		this.x = player.getX();
		this.y = player.getY();
		this.keyUser = player.getKey_User();
		if(player.getKey_User().equals("Boss Player")) {
			setIcon(new ImageIcon(Utility_Share.imgBoss));
			setBounds(x, y, 398, 300);
		}else {
			setIcon(new ImageIcon(Utility_Share.imgPlayer));
			setBounds(x, y, 82, 82);
		}
		
	}
	
	public void updateSpeed () {
		setLocation(x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	
	public int getSpeedX() {
		return speedX;
	}

	
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public int getBlood() {
		return player.getBlood();
	}

	public void setBlood(int blood) {
		player.setBlood(player.getBlood()-blood);
	}

	public boolean isAddToFrame() {
		return addToFrame;
	}

	public void setAddToFrame(boolean addToFrame) {
		this.addToFrame = addToFrame;
	}

	
	public String getKeyUser() {
		return keyUser;
	}

	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateSpeed();
	}
	
	
}
