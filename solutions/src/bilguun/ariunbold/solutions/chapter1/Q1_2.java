package bilguun.ariunbold.solutions.chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author BilguunA
 */

public class Q1_2 {
    public static void main(String[] args) {
        String s1 = "aabbccc";
        String s2 = "bbaccca";

        System.out.println(isPermutations(s1, s2));
        System.out.println(isPermutationsWithoutSorting(s1, s2));
    }

    static boolean isPermutations(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            l1.add(s1.charAt(i));
            l2.add(s2.charAt(i));
        }

        l1 = l1.stream().sorted().collect(Collectors.toList());
        l2 = l2.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < s1.length(); i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;

    }

    static boolean isPermutationsWithoutSorting(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            Integer num1 = map1.get(String.valueOf(s1.charAt(i)));
            Integer num2 = map2.get(String.valueOf(s2.charAt(i)));

            if (num1 == null) {
                num1 = 0;
            }

            if (num2 == null) {
                num2 = 0;
            }
            num1++;
            num2++;

            map1.put(String.valueOf(s1.charAt(i)), num1);
            map2.put(String.valueOf(s2.charAt(i)), num2);
        }

        for (String key : map1.keySet()) {
            Integer n1 = map1.get(key);
            Integer n2 = map2.get(key);

            if (n2 == null) {
                return false;
            }
            if (n1.intValue() != n2.intValue()) {
                return false;
            }

        }

        return true;
    }
}
