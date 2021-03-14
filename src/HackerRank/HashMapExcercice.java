package HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExcercice {

	public static void main(String[] args) {

		System.out.println(TwoStrings("hello", "world"));
		System.out.println(TwoStrings("hi", "zorld"));
	}

	
	static boolean TwoStrings(String a, String b) {
		int abeLenght = 27;
		boolean[] abc = new boolean[abeLenght + Character.getNumericValue('a')];

		for (char i : a.toCharArray()) {
			abc[Character.getNumericValue(i)] = true;
		}

		for (char i : b.toCharArray()) {
			if (abc[Character.getNumericValue(i)])
				return true;

		}

		return false;
	}
	

	
	public static void checkMagazineBestSolution(String[] magazine, String[] ransom) {

		HashMap<String, Integer> usableWords = makeMap(magazine); // 0(n)
		for (int i = 0; i < ransom.length; i++) {
			if (usableWords.containsKey(ransom[i]) && usableWords.get(ransom[i]) > 0) {
				usableWords.merge(ransom[i], -1, Integer::sum); // uses the word
			} else {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

	/* Creates and returns a HashMap out of an array of Strings */
	private static HashMap<String, Integer> makeMap(String[] words) {
		HashMap<String, Integer> map = new HashMap();
		for (int i = 0; i < words.length; i++) {
			map.merge(words[i], 1, Integer::sum);
		}
		return map;
	}

	static String checkMagazineMySolution(String magazine, String note) {

		String[] wordsInMagazine = magazine.split(" ");
		String[] wordsInNote = note.split(" ");

		HashMap<String, Integer> hashMagazine = makeMap(wordsInMagazine); // O(N)
		HashMap<String, Integer> hashNote = makeMap(wordsInNote); // O(N)

		for (Map.Entry<String, Integer> entry : hashNote.entrySet()) {
			String currentWord = entry.getKey();
			Integer countCurrentWord = entry.getValue();
			if (!hashMagazine.containsKey(currentWord) || hashMagazine.get(currentWord) < countCurrentWord)
				return "No";

		}

		return "Yes";
	}

}
