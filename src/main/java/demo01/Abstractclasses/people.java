package demo01.Abstractclasses;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/15  21:11
 */
public abstract class people {

    private String height;
    private String weight;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public abstract void play();


}
