package general;

import java.util.HashMap;
import java.util.Map;

public class GamePattern {
    public static void main(String[] args) {
        String s = "bbbbbbbbbbb";
        System.out.println(gamePattern(s));
    }

    private static String gamePattern(String colors) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < colors.length() - 1; i++) {
            char prev = colors.charAt(i - 1);
            char curr = colors.charAt(i);
            char next = colors.charAt(i + 1);
            if (prev == curr && curr == next) {
                if (curr == 'w')
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
                if (curr == 'b')
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
            }
        }
        int countW = map.getOrDefault('w', 0);
        int countB = map.getOrDefault('b', 0);

        if (countB >= countW)
            return "bob";
        else
            return "wendy";
    }
}
