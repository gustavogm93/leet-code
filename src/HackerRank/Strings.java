package HackerRank;

public class Strings {

	public static void main(String[] args) {
		System.out.println(getNumberOfCharsToDeleteToMakeAnagram("aaaabkm", "aaabkm"));

	}

	/**
	 * Making Anamgrams
	 */
	static int getNumberOfCharsToDeleteToMakeAnagram(String s1, String s2) {

		int[] abc = new int[26];

		int count = 0;

		for (char i : s1.toCharArray()) {
			abc[i - 97]++;
			count++;
		}

		for (char i : s2.toCharArray()) {

			if (abc[i - 97] == 0)
				count++;
			else {
				abc[i - 97]--;
				count--;
			}
		}

		return count;

	}

}
