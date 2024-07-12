package praktikum;

import java.util.Random;

public class Utils {
    public static String getRandomString(int stringLegth) {
        String s = "абвгдежзиклмнопрстуфхцчшщэюя";
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < stringLegth; i++) {
            str.append(s.charAt(new Random().nextInt(s.length())));
        }
        return str.toString();
    }

    public static float getRandomPrice(float min, float max) {
        return (float) ((Math.random() * (max - min)) + min);
    }

}
