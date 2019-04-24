package Utility_Share;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Random;

import Connection.ClientProgram;
import Connection.Player;
import Game_Program.EvenAll;
import Game_Program.MultiPlayer_Control;


public class Utility_Share {
	
	public static String ipServer ="" ;
	public static Dimension sSize_Frame = new Dimension(1366,768 );
	
	public static int DatagramPort = (int)(Math.random()*1000)+30000;
	public static Random sRandom = new Random();
	public static boolean isConnect = false;
	public static String namePlyer = "";
	public static EvenAll evenAll = new EvenAll();
	
	public static LinkedHashMap<String, MultiPlayer_Control> MultiPlayer = new LinkedHashMap<String, MultiPlayer_Control>();
	
	public static ClientProgram program = new ClientProgram();
	
	
	public static ClientProgram clientProgram = new ClientProgram();
	
	public static Image imgPlayer = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/player.png"));
	public static Image imgBoss = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/Boss.gif"));
	
	public static Image imgBtn_Start_Default = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_Start_Default.png"));
	public static Image imgBtn_Cr_Default = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_Cr_Default.png"));
	public static Image imgBtn_Exit_Default = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_Exit_Default.png"));
	
	public static Image imgBtn_Start_H = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_Start_H.png"));
	public static Image imgBtn_Cr_H = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_Cr_H.png"));
	public static Image imgBtn_Exit_H = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_Exit_H.png"));
	
	public static Image imgBtn_Connect_Default = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_Connect_default.png"));
	public static Image imgBtn_DisConnect_Default = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_disConnect_default.png"));
	
	public static Image imgBtn_Connect_H = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_Connect_H.png"));
	public static Image imgBtn_DisConnect_H = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/btn_disConnect_H.png"));
	
	public static Image imgMaps = Toolkit.getDefaultToolkit().createImage(Utility_Share.class.getResource("/Image/mapClient.jpg"));
}
