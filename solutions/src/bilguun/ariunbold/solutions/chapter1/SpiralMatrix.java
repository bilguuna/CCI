package bilguun.ariunbold.solutions.chapter1;

import static bilguun.ariunbold.solutions.chapter1.Utils.print;

/**
 * @author bilguuna
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Integer n = 6;
        Integer[][] arr = initArray(n);
        print(arr, n);

        System.out.println("PRINT SPIRALLY:");
        spiralPrint(arr, n);
    }

    static void spiralPrint(Integer[][] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                System.out.print(arr[i][j] + "  ");
            }

            for (int j = i + 1; j < n - i; j++) {
                System.out.print(arr[j][n - 1 - i] + "  ");
            }

            for (int j = i; j < n - 1 - i; j++) {
                System.out.print(arr[n - 1 - i][n - 2 - j] + "  ");
            }

            for (int j = n - 2 - i; j > i; j--) {
                System.out.print(arr[j][i] + "  ");
            }

        }
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
}


