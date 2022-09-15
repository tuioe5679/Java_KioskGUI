package player;

import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class Mp3Player {

    public void ttsPlay(String mp3name) {
    	 try {
             FileInputStream fis = new FileInputStream("Mp3/" + mp3name + ".mp3");
             Player playMp3 = new Player(fis);
             playMp3.play();
         } catch (Exception e) {
             System.out.println(e);
         }
    }
}