package bilguun.ariunbold.solutions.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bilguuna
 */
public class Q1_8 {
    public static void main(String[] args) {
        Integer n = 5;
        Integer m = 6;
        Integer[][] arr = initArray(n, m);
        arr[0][0] = 0;
        arr[1][2] = 0;
        arr[2][3] = 0;
        Utils.print(arr, n, m);

        System.out.println("\n\n---------AFTER ZEROED THE ARRAY-----------");
        zeroMatrix(arr, n, m);
        Utils.print(arr, n, m);


    }

    static Integer[][] zeroMatrix(Integer[][] arr, int n, int m) {
        Set<Integer> zeroedCols = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (zeroedCols.contains(j)) {
                    continue;
                }

                if (arr[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        arr[k][j] = 0;
                    }

                    for (int k = 0; k < m; k++) {
                        arr[i][k] = 0;
                    }

                    zeroedCols.add(j);
                    break;
                }
            }
        }

        return arr;
    }

    static Integer[][] initArray(int n, int m) {
        Integer[][] r = new Integer[n][m];
        Integer curr = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i][j] = curr++;
            }
        }

        return r;
    }
}
