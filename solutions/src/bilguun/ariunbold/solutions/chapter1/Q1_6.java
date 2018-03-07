package bilguun.ariunbold.solutions.chapter1;

/**
 * @author bilguuna
 */

public class Q1_6 {
    public static void main(String[] args) {
        System.out.println(compress("a"));
        System.out.println(compressWithStringBuilder("aabbbbbccccccxx"));
    }

    static String compress(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String r = String.valueOf(s.charAt(0));
        Character curr = s.charAt(0);
        int num = 1;

        for (int i = 1; i < s.length(); i++) {
            if (curr == s.charAt(i)) {
                num++;
            } else {
                r = r + num;
                num = 1;
                curr = s.charAt(i);
                r = r + curr;
            }
        }

        r = r + num;

        if (s.length() < r.length()) {
            return s;
        } else {
            return r;
        }
    }

    static String compressWithStringBuilder(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder r = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            num++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                r.append(s.charAt(i));
                r.append(num);
                num = 0;
            }
        }

        if (s.length() < r.length()) {
            return s;
        } else {
            return r.toString();
        }
    }
}


