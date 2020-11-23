import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioHandler implements Runnable
{

    //------------------------------------------------------------------------//
    String path 	 = "C:\\Myprogrmas\\com.TextBookCodeAlong\\src\\teamGame2020\\Sound";
    String theme 	 = path + "\\Themes\\acciónTheme.wav";
    String enemyExplosion= path + "enemyExplosion.wav";
    String ShootLaser	 = path + "\\SpaceShip\\ShootLaser2.wav";
    String shipExplosion = path + "shipExplosion.wav";
    String teleport = path + "\\SpaceShip\\Teleport.wav";
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
    void play(File soundFile)
    { //play any sound file
//        File file = new File(theme);
        try
        {
            AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();//
        }
        catch(Exception ex)
        { }
    }
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
        play(file);
    }

//------------------------------------------------------------------------//

    void shootLaser()
    {
        File file = new File(ShootLaser);
        play(file);
    }

//------------------------------------------------------------------------//

    void shipExplosion()
    {//play sound once
        File file = new File(shipExplosion);
        play(file);
    }
    //------------------------------------------------------------------------
    void levelComplete()
    {//play end level sound

    }

    //------------------------------------------------------------------------
    void playTeleport()
    {
        File file = new File(teleport);
        play(file);
    }
}
