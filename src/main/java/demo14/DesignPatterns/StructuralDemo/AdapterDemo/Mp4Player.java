package demo14.DesignPatterns.StructuralDemo.AdapterDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  16:10
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
