package bilguun.ariunbold.solutions.chapter1;

/**
 * @author BilguunA
 */

public class Q1_3 {
    public static void main (String[] args) {
        String s = "my name is Bilguun;                                         ";
        System.out.println(urlify(s, 18));
    }

    static String urlify(String s, int l) {
        String[] arr = new String[s.length()];

        for (int i = 0; i < l; i++) {
            arr[i] = String.valueOf(s.charAt(i));
        }

        int i = 0;
        int curr = 0;

        while(curr < l) {
            if(String.valueOf(arr[i]).equals(" ")) {
                arr = moveArray(arr, i, curr + l);
                arr[i] = "%";
                arr[++i] = "2";
                arr[++i] = "0";
            }
             i++;

            curr++;
        }

         return buildString(arr);
    }

    static String[] moveArray(String[] arr, int i, int l) {
        String temp1 = arr[i + 1];
        
        for (int j = i + 2; j < l; j++) {
            String tempLocal1 = arr[j + 1];
            arr[j + 1] = temp1;
            temp1 = tempLocal1;
        }

        return arr;
    }

    static String buildString(String[] arr) {
        String r = "";
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                break;
            }
            r = r + arr[i];
        }

        return r;
    }
}
