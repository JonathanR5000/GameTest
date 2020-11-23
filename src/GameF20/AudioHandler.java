package GameV12_proj_V2;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioHandler implements Runnable
{

    //------------------------------------------------------------------------//
    String path 	 = "";
    String theme 	 = path + "ElectricboyTheme.wav";
    String enemyExplosion= path + "enemyExplosion.wav";
    String ShootLaser	 = path + "ShootLaser.wav";
    String shipExplosion = path + "shipExplosion.wav";

    //------------------------------------------------------------------------//

// let AudioHandler run as its own thread
    public AudioHandler()
    {
        Thread musicThread = new Thread(this);
        musicThread.start();
    }
//------------------------------------------------------------------------//

    public void run()
    {
    }

 //------------------------------------------------------------------------//
	//play game theme
    public void playTheme()
    {
        File file = new File(theme);
        try
        {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.loop(Clip.LOOP_CONTINUOUSLY);//
        }
        catch(Exception ex)
        { }
    }

 //------------------------------------------------------------------------//
	//explosion sound
    void enemyExplosion()
    {//play sound once
        File file = new File(enemyExplosion);
        try
        {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();//
        }
        catch(Exception ex)
        { }
    }

//------------------------------------------------------------------------//

    void shootLaser()
    {
        File file = new File(ShootLaser);
        try
        {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();//
        }
        catch(Exception ex)
        { }
    }

//------------------------------------------------------------------------//

    void shipExplosion()
    {//play sound once
        File file = new File(shipExplosion);
        try
        {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();//
        }
        catch(Exception ex)
        { }
    }
}
