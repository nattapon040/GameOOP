package Game_Program;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import Utility_Share.Utility_Share;

import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.CompoundBorder;

public class Connection_Form_Client extends javax.swing.JFrame{
	
	public JTextField textField;
	
	public Connection_Form_Client() {
		setTitle("Connection");
		getContentPane().setLayout(null);
		setPreferredSize(new Dimension(716, 500));
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		

		getContentPane().add(new Panel_Connect(this));
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	

	
	private Image imgLogin = Toolkit.getDefaultToolkit().createImage(Menu_Form.class.getResource("/Image/login.png"));
	
	private class Panel_Connect extends javax.swing.JPanel{
		
		public Panel_Connect(Connection_Form_Client form_Client) {
			setLayout(null);
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			
			setSize(new Dimension(700, 500));
			textField = new JTextField();
			textField.setFont(new Font("PSL Kittithada", Font.BOLD, 35));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setOpaque(false);
			textField.setBorder(new CompoundBorder());
			textField.setAutoscrolls(false);
			textField.setBounds(113, 205, 472, 30);
		
			add(textField);
			textField.setColumns(10);
			
			JLabel btn_Connect = new JLabel("");
			btn_Connect.setHorizontalAlignment(SwingConstants.CENTER);
			btn_Connect.setIcon(new ImageIcon(Connection_Form_Client.class.getResource("/Image/btn_Connect_default.png")));
			btn_Connect.setBounds(360, 272, 180, 60);
			
			add(btn_Connect);
			
			JLabel btn_DisConnect = new JLabel("");
			btn_DisConnect.setHorizontalAlignment(SwingConstants.CENTER);
			btn_DisConnect.setIcon(new ImageIcon(Connection_Form_Client.class.getResource("/Image/btn_DisConnect_default.png")));
			btn_DisConnect.setBounds(164, 272, 180, 60);
			add(btn_DisConnect);
			
			
			Utility_Share.evenAll.btn_ConnectForm_Even(textField,btn_Connect, "Con",form_Client);
			Utility_Share.evenAll.btn_ConnectForm_Even(textField,btn_DisConnect, "disCon",form_Client);
			
		
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(imgLogin, 0, 0, this);
		}
	}
}
