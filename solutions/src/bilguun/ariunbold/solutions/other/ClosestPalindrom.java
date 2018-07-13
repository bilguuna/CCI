package bilguun.ariunbold.solutions.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author bilguuna
 *
 */

public class ClosestPalindrom {
	public static void main(String... args) {
		int n = 1232132;

		System.out.println(getClosestPalindrom(n));
		System.out.println(getClosestPalindromByString(n));
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

	static int getClosestPalindromByString(int n) {
		if (n < 10) {
			return n;
		}

		String stringVal = String.valueOf(n);
		int length = stringVal.length();

		String firstHalf = "";
		String closestPalindrom = "";

		firstHalf = stringVal.substring(0, length / 2);
		StringBuilder sb = new StringBuilder(firstHalf);

		if (length % 2 == 0) {
			closestPalindrom = firstHalf + sb.reverse().toString();
		} else {
			closestPalindrom = firstHalf + stringVal.charAt(length / 2) + sb.reverse().toString();
		}

		return Integer.valueOf(closestPalindrom);

	}
}
