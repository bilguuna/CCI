package bilguun.ariunbold.solutions.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BilguunA
 */

public class Q1_1 {
    public static void main(String[] args) {
        String s = "e12345689asdqwe";
        System.out.println(isUniqueWithAdditionalDataStructure(s));
        System.out.println(isUniqueWithoutAdditionalDataStructure(s));
    }

    static boolean isUniqueWithAdditionalDataStructure(String s) {
        Set<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (uniqueChars.contains(s.charAt(i))) {
                return false;
            }

            uniqueChars.add(s.charAt(i));
        }
        return true;
    }

    static boolean isUniqueWithoutAdditionalDataStructure(String s) {
        String separator = "#!";
        String uniqueChars = "";

        for (int i = 0; i < s.length(); i++) {
            if (uniqueChars.contains(s.charAt(i) + separator)) {
                return false;
            }

            uniqueChars += (separator + s.charAt(i));
        }
        return true;
    }
}
