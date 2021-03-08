package CrackingTheCodeInterview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Chapter1 {

	public static void main(String[] args) throws InterruptedException {

	}

	

/** 
 * Replace all spaces to %20
 * Input:  "Mr John Smith    ";
 * Output: "Mr%20John%20Smith" 
 */
public static String urlFy(char[] s) { 

	long startTime = System.currentTimeMillis();

	StringBuilder strbr = new StringBuilder();
	int countSpace = 0;
	int lastPositionOfAnyLetter = 0;

	for (int j = s.length - 1; j > 1; j--) {
		if (s[j] != ' ') {
			lastPositionOfAnyLetter = j;
			break;
		}
	}

	for (int i = 0; i <= lastPositionOfAnyLetter; i++) {

		if (s[i] == ' ') {
			if (countSpace == 0) {
				countSpace += 1;
				strbr.append("%20");
			}
		} else {
			countSpace = 0;
			strbr.append(s[i]);
		}

	}

	long endTime = System.currentTimeMillis();

	long timeElapsed = endTime - startTime;

	System.out.println("Execution time in milliseconds: " + timeElapsed);

		return strbr.toString();
	}
	
	
	/**
	 * Regex to get String with chars beetween a-z, without symbols char
	 * 
	 */
	public static void checkRepeatChar() {

		String str = "hola como va, todo bien!, ##muy bien turco?";

		str = str.replaceAll("[^a-zA-Z|\s]", "");

		System.out.println(str);
	}

	/**
	 * get string and map word with how many times appear
	 *
	 */
	public static HashMap<String, Integer> countWords(String frase) {

		String fraseToLowerCase = frase;
		String fraseClean = fraseToLowerCase.replaceAll("[^a-z|\s]", "");
		String[] words = fraseClean.split(" ");

		HashMap<String, Integer> listWords = new HashMap<>();

		Arrays.asList(words).stream().forEach((str) -> listWords.merge(str, 1, Integer::sum));

		Map<String, Integer> sortedMapReverseOrder = listWords.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(sortedMapReverseOrder);
		return null;
	}

	/**
	 * Recursive method to get if existe char in string return position in array or
	 * -1
	 */
	public static int getChar(int key, String ar, int lo, int hi) {

		if (lo >= hi)
			return -1;

		int mid = lo + (hi - lo) / 2;
		int charValue = ar.charAt(mid);

		System.out.println(charValue);
		System.out.println(key);

		if (charValue < key) {
			return getChar(key, ar, mid + 1, hi);
		} else if (charValue > key) {
			return getChar(key, ar, lo, mid - 1);
		} else {

			return mid;

		}

	}

	/**
	 * Recursive method to get if existe key return position in array or -1
	 */
	public static int getKey(int key, int[] ar, int lo, int hi) {

		int mid = lo + (hi - lo) / 2;

		if (lo > hi) {
			return -1;
		}

		if (ar[mid] > key) {
			getKey(key, ar, mid + 1, hi);
		}

		else if (ar[mid] < key) {
			getKey(key, ar, lo, mid - 1);
		} else {
			return mid;
		}

		return 1;
	}

	/**
	 * Recursive method to check if number exists
	 */
	public static boolean checkIfNumberExist(Integer i, Integer ar[]) {

		List<Integer> a = Arrays.asList(ar);
		Collections.sort(a);

		boolean iUpperMid = i >= a.get(a.size() / 2);

		int low = iUpperMid ? (a.size() / 2) : 0;
		int hi = iUpperMid ? a.size() : (a.size() / 2);

		for (int j = low; j < hi; j++)
			if (ar[j] == i)
				return true;

		return false;

	}

	/**
	 * Check if is unique Chars String
	 */
	public static boolean isUniqueChars(String str) {

		if (str.length() > 132)
			return false;

		System.out.println(str);
		boolean[] char_set = new boolean[128];

		for (int i = 0; i < str.length(); i++) {

			int val = str.charAt(i);
			System.out.println(val);
			if (char_set[val]) {// Already found this char in string

				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	/**
	 * Check if two strings are permution
	 */
	public static boolean checkPermution(String a, String b) {

		return toChar(a) == toChar(b);
	}

	/**
	 * String to order char[]
	 * 
	 * @param String a
	 * @return
	 */
	public static String toChar(String a) {

		char[] ab = a.toCharArray();

		Arrays.sort(ab);
		System.out.println(ab.equals(ab));
		return new String(ab);

	}

	/**
	 * Get Time between
	 * 
	 * @throws InterruptedException
	 */
	public static void getTime() throws InterruptedException {

		long startTime = System.currentTimeMillis();

		long endTime = System.currentTimeMillis();

		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in milliseconds: " + timeElapsed);

	}

}
