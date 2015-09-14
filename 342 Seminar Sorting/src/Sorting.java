import java.util.Arrays;

public class Sorting {
	public static void main(String[] args) {
		int[] list1 = {28, 17, 5, 2, 3, 4, 30, 6, 31, 38,
				39, 23, 1, 26, 29, 21, 7, 10, 9 , 13, 
				22, 33, 11, 17, 12, 15, 16, 19, 20, 25,
				24, 27, 8, 40, 42, 41, 45, 43, 44,
				46, 32, 49, 47, 48, 50, 34, 35, 36, 37};
		bubbleSort(list1.clone());
		newBubbleSort(list1.clone());
	}

	public static void bubbleSort(int[] l) {
		int numComp = 0;
		int numSwap = 0;

		System.out.println("bubbleSort()\nBefore sort: " + Arrays.toString(l));

		for (int j = 0; j < l.length - 1; j++) {
			for (int i = 0; i < l.length - 1; i++) {
				
				//comparing, so increment counter
				numComp++;
				if (l[i] > l[i + 1]) {

					//swapping, so increment counter
					numSwap++;
					final int temp = l[i];
					l[i] = l[i + 1];
					l[i + 1] = temp;

				}
			}
		}
		
		System.out.println("After sort:  " + Arrays.toString(l));
		checkSorted(l);
		System.out.println("Comparisons: " + numComp + " Swaps: " + numSwap);
	}
	
	public static void newBubbleSort(int[] l) {
		int numComp = 0;
		int numSwap = 0;

		System.out.println("\nnewBubbleSort()\nBefore sort: " + Arrays.toString(l));

		// complete method here (remember to count swaps and comparisons)
		
		System.out.println("After sort:  " + Arrays.toString(l));
		checkSorted(l);
		System.out.println("Comparisons: " + numComp + " Swaps: " + numSwap);
	}
	
	private static void checkSorted(int[] l) {
		boolean isSorted = true;
		for(int i = 0; i < l.length - 2; i++) {
			if(l[i] > l[i + 1]) {
				isSorted = false;
			}
		}
		
		if (isSorted) {
			System.out.println("Result: Success! (Sorted)");
		} else {
			System.out.println("Result: Failed! (Not sorted)");
		}
	}
}
