import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Skor {
    private String filepath;
    private InputStream music;
    private AudioStream audios;

    public Skor(String filepath) {
        this.filepath = filepath;
    }

    public void Start(){
        try{
            music = new FileInputStream(new File(filepath));
            audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    public void Stop(){
        AudioPlayer.player.stop(audios);
    }
}