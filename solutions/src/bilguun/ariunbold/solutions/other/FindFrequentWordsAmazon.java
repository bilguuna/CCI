package bilguun.ariunbold.solutions.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FindFrequentWordsAmazon {
	public static void main(String... args) {
		String text1 = "Cheese is his favorite food so that he can put cheese to any of his 100 sandwithces. ";
		String text2 = "Jack, Jill and Jim are friends from school. When they're at school, jim and jack was couple";
		String text3 = "" + //
				"The life that I have\n" + //
				"Is all that I have\n" + //
				"And the life that I have\n" + //
				"Is yours.\n" + //
				"The love that I have\n" + //
				"Of the life that I have\n" + //
				"Is yours and yours and yours.\n" + //
				"A sleep I shall have\n" + //
				"A rest I shall have\n" + //
				"Yet death will be but a pause.\n" + //
				"For the peace of my years\n" + //
				"In the long green grass\n" + //
				"Will be yours and yours and yours.";

		List<String> exclusions = Arrays.asList("is", "a", "and", "the");
		int k = 3;

		List<String> mostFrequentWords = findMostFreqWords(text3, exclusions, k);

		mostFrequentWords.forEach(System.out::println);
	}

	// - Print most K freqently used words from the given text
	// - Words from the exclusions list should be ignored
	private static List<String> findMostFreqWords(String txt, List<String> exclusions, int k) {
		// All non-alphabetical characters should be treated as whitespace
		if (txt == null || txt.trim().isEmpty()) {
			return null;
		}
		txt = txt.replaceAll("[^a-zA-Z]", " ");
		txt = txt.toLowerCase();

		String[] words = txt.split("\\s+");

		// <Word, Number of Occurencies>
		Map<String, Integer> wordFreqMap = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (exclusions.contains(word)) {
				continue;
			}

			Integer frequency = wordFreqMap.get(word);
			if (frequency == null) {
				frequency = 1;
			} else {
				frequency++;
			}

			wordFreqMap.put(word, frequency);
		}

		TreeMap<Integer, List<String>> treeMap = new TreeMap<>();

		for (String word : wordFreqMap.keySet()) {
			Integer frequency = wordFreqMap.get(word);

			List<String> wordsWithSameFreq = treeMap.get(frequency);
			if (wordsWithSameFreq == null) {
				wordsWithSameFreq = new ArrayList<>();
			}
			wordsWithSameFreq.add(word);
			treeMap.put(frequency, wordsWithSameFreq);
		}

		int i = 1;

		for (Integer freq : treeMap.descendingKeySet()) {
			if (i > k) {
			}

			System.out.println(String.format("Frequency : %d ------------", freq));
			List<String> values = treeMap.get(freq);
			System.out.println(values.stream().collect(Collectors.joining(", ")));
		}

		System.out.println(treeMap.lastKey() + ": -------------");
		return treeMap.lastEntry().getValue();
	}

}
