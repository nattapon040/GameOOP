package Game_Program;

import Utility_Share.Utility_Share;

public class FrameGame extends javax.swing.JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameGame() {
		setResizable(false);
		setSize(Utility_Share.sSize_Frame);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Menu_Form menu_Scene= new Menu_Form(this);
		getContentPane().add(menu_Scene);
		menu_Scene.setVisible(true);
		
		
		
		setLocationRelativeTo(null);
	}
	

}
