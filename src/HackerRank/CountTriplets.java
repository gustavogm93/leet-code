package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountTriplets {

	public static void main(String[] args) {

		int a[] = { 1, 3, 9, 9, 27, 81 };
		getTripletsBest(a, 3);

	}

	public static void getTripletsBest(int[] ar, int r) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : ar)
		map.merge(i, 1, Integer::sum);


	int i = 0;
	while (i < ar.length) {

		int toFind = ar[i] * r;

		if (map.get(toFind) != null) {

			int totoFind = toFind * r;

			if (map.get(totoFind) != null) {

				if (isPositive(map, ar[i], toFind, totoFind)) {
					map.merge(ar[i], -1, Integer::sum);
					map.merge(toFind, -1, Integer::sum);
					map.merge(totoFind, -1, Integer::sum);
					count++;
				} 

			} 
		} 
		
		i++;
		
	}

		System.out.println(count);
	}





	public static boolean isPositive(HashMap<Integer, Integer> map, int i, int i2, int i3) {

		int val1 =map.get(i);
		int val2 =map.get(i2);
		int val3 =map.get(i3);
		
		return val1 > 0 || val2 > 0 || val3 > 0;

	}

	public int binarySum(Integer i) {

		return 1;
	}

	public static void getTriplets(int[] ar, int r) {

		int counters = 1;
		List<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < ar.length; i++) {

			int toFind = ar[i] * r;

			int position = Arrays.binarySearch(ar, toFind);
			indexes.add(i);

			if (position > 0) {
				counters++;
				indexes.add(position);
				int toFindSecond = toFind * r;

				int position2 = Arrays.binarySearch(ar, toFindSecond);

				if (position2 > 0) {
					counters++;
					indexes.add(position2);

					for (Integer integer : indexes) {
						System.out.print(String.format("%d ", integer));
					}
					System.out.println("");
					indexes.clear();
				}

			}
			counters = 1;

		}
//SACARLO DE UAN LISTA
	}
}
