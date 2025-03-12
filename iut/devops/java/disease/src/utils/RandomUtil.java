package utils;

import java.util.List;

public class RandomUtil {

    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static <T> T getRandomFromList(List<T> list) {
        return list.get(randomInt(0, list.size() - 1));
    }
}
