package Game_Program;

import Utility_Share.Utility_Share;

public class Frame extends javax.swing.JFrame{
	
	public Frame() {
		setResizable(false);
		setPreferredSize(Utility_Share.sSize_Frame);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*Menu_Form menu_Scene= new Menu_Form(this);
		getContentPane().add(menu_Scene);
		*/
		
		
		setLocationRelativeTo(null);
	}
	

}
