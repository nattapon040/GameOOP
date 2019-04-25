package Game_Program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import Connection.Player;
import Utility_Share.Utility_Share;

public class Single_Control extends JLabel implements KeyListener,ActionListener{
	private int x,y;
	private int speedX=0,speedY=0;

	private Timer timer;
	private int blood;
	public static String KeyUser = "Player "+Utility_Share.sRandom.nextInt(255);
	public Single_Control(int x, int y) {
		this.x = x;
		this.y = y;
		timer = new  Timer(30, this);
		timer.start();
		
		Utility_Share.player = new Player(KeyUser, x, y);
		Utility_Share.player.setBlood(260);
		this.blood = Utility_Share.player.getBlood();
		
		setBounds(x, y, 82, 82);
		setIcon(new ImageIcon(Utility_Share.imgPlayer));
		addKeyListener(this);
		setFocusable(true);

		requestFocus();
	}

	public void update() {
		x+=speedX;
		y+=speedY;
		if(x<0) {
			x = 0;
		}

		if(x>=1290) {
			x=1290;
		}
		
		if(y<0) {
			y=0;
		}
		
		if(y>=690) {
			y=690;
		}
		Utility_Share.player.setX(x);
		Utility_Share.player.setY(y);		
		
		Utility_Share.player.setSpeedX(speedX);
		Utility_Share.player.setSpeedY(speedY);
		setLocation(x, y);
		
		SendThread th = new SendThread(Utility_Share.clientProgram, Utility_Share.player);
		th.start();
		
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		
		int key = k.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			speedX=10;
			
		}else if(key == KeyEvent.VK_LEFT) {
			speedX=-10;
			
		}else if(key == KeyEvent.VK_DOWN) {
			speedY=10;
			
		}else if(key == KeyEvent.VK_UP) {
			speedY =-10;
			
		}
		//System.out.println("X" + x +" Y"+y);
		
		//update();
		//MainClass.program.channel.send(player);
		
		
	}
	@Override
	public void keyReleased(KeyEvent k) {
		
		if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
			speedX=0;
		}else if(k.getKeyCode() == KeyEvent.VK_LEFT) {
			speedX=0;
		}else if(k.getKeyCode()== KeyEvent.VK_DOWN) {
			speedY=0;
		}else if(k.getKeyCode() == KeyEvent.VK_UP) {
			speedY =0;
		}
		
		
		Utility_Share.player.setSpeedX(0);
		Utility_Share.player.setSpeedY(0);
		//update();

		//MainClass.program.channel.send(player);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		//requestFocus();
		update();
		//System.out.println(getX() +"X  Y"+ getY());
		
		}
	public static Single_Control getInstance() {
		return getInstance();
	}
	
	
	
	
}
