package bilguun.ariunbold.solutions.chapter1;

/**
 * @author BilguunA
 */

public class Q1_3 {
    public static void main (String[] args) {
        String s = "my name is Bilguun;                     ";
        System.out.println(urlify(s, 18));
    }

    static String urlify(String s, int l) {
        String[] arr = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = String.valueOf(s.charAt(i));
        }

        for (int i = 0; i < arr.length; i++) {
            if(String.valueOf(arr[i]).equals(" ")) {
                arr = moveArray(arr, i, l);
                arr[i] = "%";
                arr[i + 1] = "2";
            }
        }

        return buildString(arr);
    }

    static String buildString(String[] arr) {
        String r = "";
        for (int i = 0; i < arr.length; i++) {
            r = r + arr[i];
        }

        return r;
    }

    static String[] moveArray(String[] arr, int i, int l) {
        String temp = arr[i + 1];

        for (int j = i + 1; j < arr.length; j++) {
            String tempLocal = arr[j + 1];
            arr[j + 1] = temp;
            temp = tempLocal;
        }

        return arr;
    }
}
