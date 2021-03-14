package CrackingTheCodeInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayAndString {

	public static void main(String[] args) throws InterruptedException {

		// charRepeatedThreeTimes("aaba");
		/*
		 * a 7 b 1 e 1 d 1 h 8 m 3 z 1
		 */

		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		/*zeroInColumnAndRows(a); */
		
		zeroInColumnAndRows(a);

	}

	
	
	boolean isRotation(String sl, String s2) {
 int len = sl.length();
 /* Check that sl and s2 are equal length and not empty*/
 if (len == s2.length() && len > 0) {
 /* Concatenate sl and sl within new buffer */
 String slsl = sl + sl;
 return slsl.contains(s2);
 }
 return false;
 } 
	
	
	static boolean isSubstringRotation(String a, String b) {
	
		if(a.length() != b.length())
			return false;
		
		int j=0;
		StringBuilder strWrongPositionated = new StringBuilder();
		StringBuilder strCorrectPositionated = new StringBuilder();

	
		for(int i=0; i<a.length(); i ++) {
			
			if(a.charAt(i) != b.charAt(j)) {
				strWrongPositionated.append(a.charAt(i));
			}
			else {
				strCorrectPositionated.append(a.charAt(i));
				j++;
			}
			
			
		}
		
		System.out.println(strWrongPositionated);
		System.out.println(strCorrectPositionated);
		
		return strWrongPositionated.toString()
                                   .concat(strCorrectPositionated.toString())
                                   .equals(a);

	}

	/**
	 * Zero in columns and rows
	 */
	static void zeroInColumnAndRows(int[][] matrix) {
		int size = matrix.length;

		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				if (rows.contains(i))
					matrix[i][j] = 0;
				else {
					if (cols.contains(j))
						matrix[i][j] = 0;
				}
				System.out.print(matrix[i][j] + ", ");
			}

			System.out.println("");
		}

	}

	/**
	 * rotate 90° book solution
	 */
	static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length)

			return false;

		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {

			int first = layer;
			int last = n - 1 - layer;

			for (int i = first; i < last; i++) {

				int offset = i - first;

				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right<- saved top
			}
		}

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + ", ");

			}
			System.out.println("");
		}

		return true;
	}

	/**
	 * Rotate 90° matrix array
	 */
	static void Grades(int[][] ar) {

		int size = ar[0].length;
		int max = size - 1;
		int[][] b = new int[4][4];

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {
				b[j][max - i] = ar[i][j];
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
			}
		}
	}

	/**
	 * Compression of a string aaaabbbb -> a4b4
	 */
	static String stringCompression(String a) {

		char lastCharAdd = a.charAt(0);
		char endChar = a.charAt(a.length() - 1);

		int count = 0;
		StringBuilder strBuilder = new StringBuilder();

		LinkedHashMap<Character, Integer> letters = new LinkedHashMap<>();

		for (char i : a.toCharArray()) {
			letters.merge(i, 1, Integer::sum);
		}

		System.out.println(letters.toString());

		return strBuilder.toString();
	}

	/**
	 * check if two string has almost one dif can be deleted char or replace char
	 * "pale" -> "pal" ---> only 1 char delete OK
	 */
	static boolean oneEdit(String a, String b) {
		int diff = Math.abs(a.length() - b.length());
		int count = 0;

		if (diff > 1 || diff < 0)
			return false;

		// Edited
		if (diff == 0) {
			for (int i = 0; i < a.length(); i++)

				if (a.charAt(i) != b.charAt(i))
					count++;

			if (count > 1)
				return false;
		}

		// Deleted
		if (diff == 1) {

			a = a.length() > b.length() ? a : b;
			b = a.length() < b.length() ? b : a;

			for (int i = 0, j = 0; i < a.length() && j < b.length(); i++) {

				if (a.charAt(i) == b.charAt(j)) {
					j++;
				} else {
					count++;
				}

				if (count > 1)
					return false;

			}

		}
		return true;

	}

	/**
	 * check if string has 3 chars equals
	 */
	static boolean charRepeatedThreeTimes(String phrase) {

		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];

		for (char c : phrase.toCharArray()) {

			if (c != -1) {
				int x = Character.getNumericValue(c);

				table[x]++;
				if (table[x] == 3) {
					System.out.format(" %s -> 3X", c);
				}
			}

		}

		return true;
	}

	/**
	 * check if string in backfoward is same to original
	 */
	static boolean writedBackfowardIsSame(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;

		for (int i = 0, j = s1.length() - 1; i < s1.length(); i++, j--) {

			if (s1.charAt(i) != s2.charAt(j))
				return false;
		}

		return true;
	}

	/**
	 * Check if string is permutation of a palindrome
	 */
	static boolean isPermutationOfPalindrome(String phrase) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 5];

		for (char c : phrase.toCharArray()) {
			int x = Character.getNumericValue(c);
			if (x != -1) {
				table[x]++;
				if (table[x] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}

	/**
	 * Replace all spaces to %20 Input: "Mr John Smith "; Output:
	 * "Mr%20John%20Smith"
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
