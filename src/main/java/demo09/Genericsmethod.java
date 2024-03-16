package demo09;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/16  19:02
 */
public class Genericsmethod {

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}
