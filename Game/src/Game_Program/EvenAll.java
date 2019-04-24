package Game_Program;

import java.awt.Menu;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Connection.ClientProgram;
import Utility_Share.Utility_Share;

public class EvenAll {

	private Frame form;
	public void btn_MenuForm_Even(JLabel label,String status,Frame form) {	
		this.form = form;
		
		//MouseAdapter
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(status.equals("st")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Start_Default));
					
					if(Utility_Share.isConnect == false) {
						
						Connection_Form_Client client = new Connection_Form_Client();
						return;
					}else {
						
						Map_Game game = new Map_Game();
						game.setVisible(true);
						form.setVisible(false);
					}
					
					
					
				}else if(status.equals("exit")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Exit_Default));
					System.exit(0);
					return;
				}else if(status.equals("cr")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Cr_Default));
					return;
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(status.equals("st")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Start_H));
					return;
				}else if(status.equals("exit")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Exit_H));
					return;
				}else if(status.equals("cr")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Cr_H));
					return;
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(status.equals("st")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Start_H));
					return;
				}else if(status.equals("exit")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Exit_H));
					return;
				}else if(status.equals("cr")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Cr_H));
					return;
				}
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(status.equals("st")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Start_Default));
					return;
				}else if(status.equals("exit")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Exit_Default));
					return;
				}else if(status.equals("cr")) {
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Cr_Default));
					return;
				}
			}
		});
	}
	
	
	public void btn_ConnectForm_Even(JTextField field,JLabel label,String status,Connection_Form_Client clientForm) {
		label.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				if(status.equals("Con")){
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Connect_Default));
					
					
					if(clientForm.textField.getText().trim().isEmpty()) {
						  try {
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
								| UnsupportedLookAndFeelException e1) {
							e1.printStackTrace();
						}
				          JOptionPane.showMessageDialog(null, "Please Input PlayerName", "WARNING",  JOptionPane.WARNING_MESSAGE);
				          return;
					}
					try {
						System.out.println(1);
							if(Utility_Share.isConnect == false) {
								System.out.println(2);
																
								Utility_Share.clientProgram.start();
								Utility_Share.namePlyer = field.getText().trim();
								
								return;
							}		
							} catch (Exception es) {	
								
						} 
					
					clientForm.setVisible(false);
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Connect_Default));
					return;
				}
				if (status.equals("disCon")) {
					clientForm.setVisible(false);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(status.equals("Con")){
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Connect_Default));
					
					return;
				}
				label.setIcon(new ImageIcon(Utility_Share.imgBtn_DisConnect_Default));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(status.equals("Con")){
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Connect_H));
					return;
				}
				label.setIcon(new ImageIcon(Utility_Share.imgBtn_DisConnect_H));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(status.equals("Con")){
					label.setIcon(new ImageIcon(Utility_Share.imgBtn_Connect_H));
					return;
				}
				label.setIcon(new ImageIcon(Utility_Share.imgBtn_DisConnect_H));
			}
		});
	}
	
}
