import java.util.Arrays;

class iterativeSelectionSort {
	// Utility function to swap values at two indices in the array
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Function to perform selection sort on arr[]
	public static void iterativeSelectionSort(int[] arr) {
		// run (arr.length - 1) times
		for (int i = 0; i < arr.length - 1; i++) {
			// find the minimum element in the unsorted sub-array[i..n-1]
			// and swap it with arr[i]
			int min = i;

			for (int j = i + 1; j < arr.length; j++) {
				// if arr[j] element is less, then it is the new minimum
				if (arr[j] < arr[min]) {
					min = j;	// update index of min element
				}
			}

			// swap the minimum element in sub-array[i..n-1] with arr[i]
			swap(arr, min, i);
		}
	}

	// Recursive function to perform selection sort on sub-array arr[i..n-1]
	public static void recursiveSelectionSort(int[] arr, int i, int n) {
		// find the minimum element in the unsorted sub-array[i..n-1]
		// and swap it with arr[i]
		int min = i;
		for (int j = i + 1; j < n; j++) {
			// if arr[j] element is less, then it is the new minimum
			if (arr[j] < arr[min]) {
				min = j;	// update index of min element
			}
		}

		// swap the minimum element in sub-array[i..n-1] with arr[i]
		swap(arr, min, i);

		if (i + 1 < n) {
			recursiveSelectionSort(arr, i + 1, n);
		}
	}

	public static void main(String[] args) {
		int arr1[] = arr2[] = { 3, 5, 8, 4, 1, 9, -2 };

		iterativeSelectionSort(arr1);
    recursiveSelectionSort(arr2, 0, arr2.length);

		// print the sorted arrays
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
}
