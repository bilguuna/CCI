package bilguun.ariunbold.solutions.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q1_2 {
    public static void main(String[] args) {
        String s1 = "asdasd";
        String s2 = "dsadas";

        System.out.println(isPermutations(s1, s2));
    }

    static boolean isPermutations(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        if(s1.length() != s2.length()) {
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
            if(!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;

    }
}
