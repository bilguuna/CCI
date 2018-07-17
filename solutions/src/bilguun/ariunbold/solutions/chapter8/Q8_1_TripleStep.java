package bilguun.ariunbold.solutions.chapter8;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author bilguuna
 *
 */

public class Q8_1_TripleStep {

	public static void main(String... args) {
		System.out.println(countWays(6));
		System.out.println(countWaysWithMemoization(6, new HashMap<>()));
	}

	static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

	static int countWaysWithMemoization(int n, Map<Integer, Integer> memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			if (memo.containsKey(n)) {
				return memo.get(n);
			} else {
				memo.put(n, countWaysWithMemoization(n - 1, memo) + countWaysWithMemoization(n - 2, memo)
						+ countWaysWithMemoization(n - 3, memo));
				return memo.get(n);
			}
		}
	}
}
