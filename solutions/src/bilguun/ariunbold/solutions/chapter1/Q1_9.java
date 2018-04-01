package bilguun.ariunbold.solutions.chapter1;

/**
 * @author bilguuna
 */
public class Q1_9 {
    public static void main(String[] args) {
        String s1 = "waterbottle1";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        return (s1 + s1).contains(s2);
    }
}
