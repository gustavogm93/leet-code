package HackerRank;

import java.util.Arrays;

public class IceCreamParlor {

	public static void main(String[] args) {

		int a[] = { 2, 1,4, 8, 5, 6, 7 };
		whatFlavors(a, 5);
	}

	static void whatFlavors(int[] cost, int money) {
		Arrays.sort(cost);

		int firstBuy = money - 1;
		int averageFind = cost.length / 2;

		int maxIndex = averageFind;

		
		if (cost[averageFind] < firstBuy) {
			maxIndex = averageFind + 1;
			for (int i = averageFind; i < cost.length; i++) {
				if (cost[i] > firstBuy)
					break;
				else
					maxIndex = i;
			}

		} else if  (cost[averageFind] > firstBuy){
			maxIndex = averageFind -1;
			for (int i = averageFind; i > 0; i--) {
				if (cost[i] < firstBuy)
					break;
				else
					maxIndex = i;
			}
		}
			

		int diffToFind = money - cost[maxIndex];
		for (int i = 0, j = maxIndex; i < maxIndex; i++) {

			if (i == j)
				break;

			if (cost[i] > diffToFind) {
				i = 0;
				j--;

				diffToFind = money - cost[j];
			}

			if ((cost[maxIndex] - cost[i]) == diffToFind) {
				System.out.println(i+1);

				System.out.println(j+1);
				
			}

		}

		
	}

}
