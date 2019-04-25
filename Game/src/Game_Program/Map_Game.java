package Game_Program;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;

import Utility_Share.Utility_Share;

public class Map_Game extends javax.swing.JFrame{
	
	public Map_Game() {
		
		setSize(Utility_Share.sSize_Frame);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("WAR OF AIRSTRIKE");
		
		
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					System.out.println(1554);
					if(Utility_Share.clientProgram.channel != null) {
						Utility_Share.clientProgram.channel.stop();
						setVisible(false);
						FrameGame frame = new FrameGame();
						frame.setVisible(true);
						//****
						return;
					}
					
					System.out.println("NUll");
					
				} catch (IOException e1) {
					  
				}
			}
		});
		
		getContentPane().add(new Panel_Map());
		
	}
	
	private class Panel_Map extends JPanel implements ActionListener{
		
		private Timer timer;
		private Single_Control control;
		public Panel_Map() {
			
			timer = new Timer(1, this);
			timer.start();
			setSize(Utility_Share.sSize_Frame);
			setLayout(null);
			
			control = new Single_Control(500, 600);
			add(control);
			requestFocus();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(Utility_Share.imgMaps, 0, 0, 1366, 768, 0, 0, 1382, 809, this);
			
			
			g.setColor(Color.RED);
			g.fillRoundRect(7, 9, 355, 20, 25, 25);
			g.setFont(new Font("PSL Kitthada", Font.PLAIN, 18));
			g.setColor(Color.RED);
			g.drawString("Dark Vader "+ 355, 20,100);
			
			g.setColor(Color.green);
			g.fillRoundRect(1078, 663, Utility_Share.player.getBlood(), 22, 25, 25);
			g.setFont(new Font("PSL Kitthada", Font.PLAIN, 18));
			
			g.setColor(Color.CYAN);
			g.fillRoundRect(1078, 694, Utility_Share.player.getBlood(), 22, 25, 25);
			g.setFont(new Font("PSL Kitthada", Font.PLAIN, 18));
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			for (Map.Entry<String, MultiPlayer_Control> entry : Utility_Share.MultiPlayer.entrySet()) {
				String key = entry.getKey();
				MultiPlayer_Control multiPlayer = Utility_Share.MultiPlayer.get(key);
				if(multiPlayer.isAddToFrame() == false && (!multiPlayer.getKeyUser().equals(Utility_Share.player.getKey_User()))) {
					add(Utility_Share.MultiPlayer.get(key));
				}
			}
		}
		
	}
}
