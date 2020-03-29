import java.util.Arrays;

class BubbleSort {
	// Utility function to swap values at two indices in the array
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Function to perform bubble sort on arr[]
	public static void iterativeBubbleSort(int arr[]) {
		// (arr.length - 1) pass
		for (int k = 0; k < arr.length - 1; k++)
		{
			// last k items are already sorted, so inner loop can
			// avoid looking at the last k items
			for (int i = 0; i < arr.length - 1 - k; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}

			// the algorithm can be stopped if the inner loop
			// didn’t do any swap
		}
	}

  // Recursive function to perform bubble sort on sub-array arr[i..n]
	public static void recursiveBubbleSort(int arr[], int n) {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
			}
		}

		if (n - 1 > 1) {
			recursiveBubbleSort(arr, n - 1);
		}
	}

	public static void main(String[] args) {
		int arr1[] = arr2[] = { 3, 5, 8, 4, 1, 9, -2 };

		iterativeBubbleSort(arr1);
    recursiveBubbleSort(arr2, arr2.length);

		// print the sorted arrays
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
}