package bilguun.ariunbold.solutions.chapter1;

/**
 * @author bilguuna
 */

public class Q1_7 {
    public static void main(String[] args) {
        Integer n = 5;
        Integer[][] arr = initArray(n);
        print(arr, n);

        arr = rotate(arr, n);

        System.out.println("");
        System.out.println("");
        System.out.println("---------AFTER ROTATE-----------");
        print(arr, n);

    }

    static Integer[][] initArray(int n) {
        Integer[][] r = new Integer[n][n];
        Integer curr = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[i][j] = curr++;
            }
        }

        return r;
    }

    static Integer[][] rotate(Integer[][] arr, Integer n) {
        Integer[][] r = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[j][n - 1 - i] = arr[i][j];
            }
        }

        return r;
    }

    static void print(Integer[][] arr, Integer n) {
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 9) {
                    System.out.print(arr[i][j] + "  ");
                } else {
                    System.out.print(arr[i][j] + "   ");
                }
            }
        }
    }
}
