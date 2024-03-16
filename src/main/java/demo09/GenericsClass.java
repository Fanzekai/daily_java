package demo09;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/16  19:01
 */
public class GenericsClass<T, U> {
    private T first;
    private U second;

    public GenericsClass(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
