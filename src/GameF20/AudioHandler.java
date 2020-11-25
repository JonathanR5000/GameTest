import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioHandler implements Runnable
{

    //------------------------------------------------------------------------//
    String path 	 = "C:\\Myprogrmas\\com.TextBookCodeAlong\\src\\teamGame2020\\Sound";
    File theme 	 = new File(path + "\\Themes\\acciónTheme.wav");
    File enemyExplosion= new File(path + "enemyExplosion.wav");
    File ShootLaser	 = new File(path + "\\SpaceShip\\ShootLaser2.wav");
    File shipExplosion = new File(path + "shipExplosion.wav");
    File teleport = new File(path + "\\SpaceShip\\Teleport.wav");
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
        try
        {
            AudioInputStream sound = AudioSystem.getAudioInputStream(theme);
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
        
        play(enemyExplosion);
    }

//------------------------------------------------------------------------//

    void shootLaser()
    {
        play(ShootLaser);
    }

//------------------------------------------------------------------------//

    void shipExplosion()
    {//play sound once
        play(shipExplosion);
    }
    //------------------------------------------------------------------------
    void levelComplete()
    {//play end level sound

    }

    //------------------------------------------------------------------------
    void playTeleport()
    {
        play(teleport);
    }
