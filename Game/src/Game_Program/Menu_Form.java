package Game_Program;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Utility_Share.Utility_Share;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Color;

public class Menu_Form extends javax.swing.JPanel implements ActionListener{

	private Timer timer;
	
	public Menu_Form(FrameGame frame) {
		setSize(Utility_Share.sSize_Frame);
		timer = new Timer(1, this);
		timer.start();
		
		setLayout(null);
		JLabel btn_Start = new JLabel("");
		btn_Start.setIcon(new ImageIcon(Utility_Share.imgBtn_Start_Default));
		btn_Start.setBounds(69, 411, 232, 53);
		add(btn_Start);
		
		JLabel btn_Cr = new JLabel("");
		btn_Cr.setIcon(new ImageIcon(Utility_Share.imgBtn_Cr_Default));
		btn_Cr.setBounds(69, 493, 259, 53);
		add(btn_Cr);
		
		JLabel btn_exit = new JLabel("");
		btn_exit.setIcon(new ImageIcon(Utility_Share.imgBtn_Exit_Default));
		btn_exit.setBounds(69, 573, 175, 53);
		add(btn_exit);
			
		

		Utility_Share.evenAll.btn_MenuForm_Even(btn_exit, "exit",frame);
		Utility_Share.evenAll.btn_MenuForm_Even(btn_Cr, "cr",frame);
		Utility_Share.evenAll.btn_MenuForm_Even(btn_Start, "st",frame);
		
	}
	
	private Image imgMenu = Toolkit.getDefaultToolkit().createImage(Menu_Form.class.getResource("/Image/menu.png"));
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(imgMenu, 0, 0, this);
		
		if(Utility_Share.isConnect == false) {
			g.setColor(Color.RED);
		}else {
			g.setColor(Color.GREEN);
		}
		g.drawString((Utility_Share.isConnect ==true) ? Utility_Share.namePlyer  +" Online": "Offline" , 1200, 700);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
