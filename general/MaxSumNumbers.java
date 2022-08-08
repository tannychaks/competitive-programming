package general;

public class MaxSumNumbers {
    public static void main(String[] args) {
        String s = "99999";
        System.out.println(maximumString(s));

    }

    private static String maximumString(String s) {

        int x = Integer.parseInt(s.substring(0, 1));
        int y = Integer.parseInt(s.substring(1, 2));
        int max = x + y;
        if (max >= 10)
            max = 0;
        int from = 0, to = s.length();
        for (int i = 1; i < s.length() - 1; i++) {
            x = Integer.parseInt(s.substring(i, i + 1));
            y = Integer.parseInt(s.substring(i + 1, i + 2));

            if (max <= (x + y)) {
                max = x + y;
                from = i;
                to = i + 1;
            }

        }
        StringBuilder modifiedS = new StringBuilder(s);
        modifiedS.replace(from, to + 1, String.valueOf(max));

        return modifiedS.toString();
    }
}
