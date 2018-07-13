package bilguun.ariunbold.solutions.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author bilguuna
 *
 */

public class ClosesPalindrom {
	public static void main(String... args) {
		System.out.println(getClosestPalindrom(231921));
	}

	static int getClosestPalindrom(int n) {
		if (n < 10) {
			return n;
		}
		Stack<Integer> stack = new Stack<>();

		while (n > 0) {
			int digit = n % 10;
			stack.push(digit);
			n = n / 10;
		}

		List<Integer> digits = new ArrayList<>();

		while (!stack.isEmpty()) {
			digits.add(stack.pop());
		}
		int r = 0;

		for (int i = 0; i < digits.size() / 2; i++) {
			int left = digits.get(i);
			int right = digits.get(digits.size() - 1 - i);

			if (left != right) {
				digits.set(digits.size() - 1 - i, left);
			}
		}

		for (int i = 0; i < digits.size(); i++) {
			r = r * 10 + digits.get(i);
		}
		return r;
	}
}
