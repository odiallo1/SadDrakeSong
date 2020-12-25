package loopMusic;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class musicStuff {
	void playMusic(String musicLocation) {
		try 
		{
			File musicPath = new File(musicLocation);
			if(musicPath.exists()) 
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(clip.LOOP_CONTINUOUSLY);
				
				//pause
				JOptionPane.showMessageDialog(null, "press ok to pause");
				long clipTimePosition = clip.getMicrosecondPosition();
				clip.stop();
				
				//resume
				JOptionPane.showMessageDialog(null, "press ok to resume");
				clip.setMicrosecondPosition(clipTimePosition);
				clip.start();
				
				//stop playing
				JOptionPane.showMessageDialog(null, "press ok to stop playing");
			}
			else 
			{
				System.out.println("Can't find file.");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
