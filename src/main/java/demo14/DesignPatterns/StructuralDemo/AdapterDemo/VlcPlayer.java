package demo14.DesignPatterns.StructuralDemo.AdapterDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  16:10
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
