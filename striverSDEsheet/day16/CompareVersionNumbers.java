package striverSDEsheet.day16;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        int ans = compareVersion(version1, version2);
        System.out.println(ans);
    }

    private static int compareVersion(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            while (i < n1 && version1.charAt(i) != '.')
                a.append(version1.charAt(i++));

            while (j < n2 && version2.charAt(j) != '.')
                b.append(version2.charAt(j++));

            if (a.length() == 0)
                a.append("0");
            if (b.length() == 0)
                b.append("0");
            int numA = Integer.parseInt(a.toString());
            int numB = Integer.parseInt(b.toString());

            if (numA < numB)
                return -1;
            else if (numA > numB)
                return 1;
            i++;
            j++;
        }
        return 0;
    }

}
