package Media;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class playSound implements Runnable{
	
	private Clip clip ;
	private String path;
	public playSound(String path) {
		this.path = path;
		Thread thread = new Thread(this);
		thread.start();
	}
	public void playSound(File effect_Path) {
		try {
			clip  = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(effect_Path));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		} catch (LineUnavailableException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {e.printStackTrace();} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		//playSound(new File("D:\\War of AirStrike\\Game\\src\\Media\\SoundGame.wav"));
	}
	
}
