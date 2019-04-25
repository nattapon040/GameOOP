package Game_Program;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import Utility_Share.Utility_Share;

import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.CompoundBorder;


public class Connection_Form_Client extends javax.swing.JFrame{
	
	public JTextField textField;
	
	public Connection_Form_Client() {
		setTitle("Connection");
		
		setLayout(null);
		setSize(new Dimension(716, 500));
		
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		textField = new JTextField();
		textField.setFont(new Font("PSL Kittithada", Font.BOLD, 35));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setOpaque(false);
		textField.setBorder(new CompoundBorder());
		textField.setAutoscrolls(false);
		textField.setBounds(113, 198, 472, 30);
	
		add(textField);
		textField.setColumns(10);
		
		JLabel btn_Connect = new JLabel("");
		btn_Connect.setHorizontalAlignment(SwingConstants.CENTER);
		btn_Connect.setIcon(new ImageIcon(Utility_Share.imgBtn_Connect_Default));
		btn_Connect.setBounds(360, 272, 180, 60);
		
		add(btn_Connect);
		
		JLabel btn_DisConnect = new JLabel("");
		btn_DisConnect.setHorizontalAlignment(SwingConstants.CENTER);
		btn_DisConnect.setIcon(new ImageIcon(Utility_Share.imgBtn_DisConnect_Default));
		btn_DisConnect.setBounds(164, 272, 180, 60);
		add(btn_DisConnect);
			
		
		Utility_Share.evenAll.btn_ConnectForm_Even(textField,btn_Connect, "Con",this);
		Utility_Share.evenAll.btn_ConnectForm_Even(textField,btn_DisConnect, "disCon",this);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Connection_Form_Client.class.getResource("/Image/login.png")));
		lblNewLabel.setBounds(0, 0, 710, 471);
		add(lblNewLabel);
		
		
		setVisible(true);
	}
}

