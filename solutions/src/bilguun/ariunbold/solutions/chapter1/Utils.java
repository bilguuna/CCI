package bilguun.ariunbold.solutions.chapter1;

public class Utils {
    static void print(Integer[][] arr, Integer n, Integer m) {
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 9) {
                    System.out.print(arr[i][j] + "  ");
                } else {
                    System.out.print(arr[i][j] + "   ");
                }
            }
        }
    }

    static void print(Integer[][] arr, Integer n) {
        print(arr, n, n);
    }
}
