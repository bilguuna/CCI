package bilguun.ariunbold.solutions.chapter1;

/**
 * @author bilguuna
 */

public class Q1_7 {
    public static void main(String[] args) {
        Integer n = 6;
        Integer[][] arr = initArray(n);
        print(arr, n);

        arr = rotate(arr, n);
        System.out.println("\n\n---------AFTER ROTATE USING ADDITIONAL ARRAY-----------");
        print(arr, n);

        arr = initArray(n);
        arr = rotateInPlace(arr, n);
        System.out.println("\n\n---------AFTER ROTATE IN PLACE-----------");
        print(arr, n);

    }

    static Integer[][] rotateInPlace(Integer[][] arr, Integer n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[n - 1 - j][i];
                arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
                arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
                arr[j][n - 1 - i] = tmp;
            }
        }

        return arr;
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
