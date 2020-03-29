import java.util.Arrays;

class MergeSort {
	// Merge two sorted sub-arrays arr[low .. mid] and arr[mid + 1 .. high]
	public static void merge(int[] arr, int[] aux, int low, int mid, int high) {
		int k = low, i = low, j = mid + 1;

		// While there are elements in the left and right runs
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				aux[k++] = arr[i++];
			}
			else {
				aux[k++] = arr[j++];
			}
		}

		// Copy remaining elements
		while (i <= mid) {
			aux[k++] = arr[i++];
		}

		// No need to copy the second half

		// copy back to the original array to reflect sorted order
		for (i = low; i <= high; i++) {
			arr[i] = aux[i];
		}
	}

	// Sort array arr [low..high] using auxiliary array aux
	public static void recursiveMergeSort(int[] arr, int[] aux, int low, int high) {
		// Base case
		if (high == low) {	// if run size == 1
			return;
		}

		// find mid point
		int mid = (low + ((high - low) >> 1));

		// recursively split runs into two halves until run size == 1,
		// then merge them and return back up the call chain

		recursiveMergeSort(arr, aux, low, mid);	  // split / merge left  half
		recursiveMergeSort(arr, aux, mid + 1, high); // split / merge right half

		merge(arr, aux, low, mid, high);	// merge the two half runs
	}

  // Iteratively sort array A[low..high] using temporary array
	public static void iterativeMergeSort(int[] A) {
		int low = 0;
		int high = A.length - 1;

		// sort array A[] using temporary array temp
		int[] temp = Arrays.copyOf(A, A.length);

		// divide the array into blocks of size m
		// m = [1, 2, 4, 8, 16...]
		for (int m = 1; m <= high - low; m = 2*m) {
			// for m = 1, i = 0, 2, 4, 6, 8...
			// for m = 2, i = 0, 4, 8, 12...
			// for m = 4, i = 0, 8, 16...
			// ...
			for (int i = low; i < high; i += 2*m) {
				int from = i;
				int mid = i + m - 1;
				int to = Integer.min(i + 2 * m - 1, high);

				merge(A, temp, from, mid, to);
			}
		}
	}

	// Function to check if arr is sorted in ascending order or not
	public static boolean isSorted(int[] arr) {
		int prev = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (prev > arr[i]) {
				System.out.println("MergeSort Fails!!");
				return false;
			}
			prev = arr[i];
		}

		return true;
	}

	public static void main(String[] args) {
		int[] arr1 = arr2 = { 12, 3, 18, 24, 0, 5, -2 };
		int[] aux = Arrays.copyOf(arr1, arr1.length);

		// sort array 'arr' using auxiliary array 'aux'
		recursiveMergeSort(arr1, aux, 0, arr1.length - 1);
		iterativeMergeSort(arr2);

		if (isSorted(arr1)) System.out.println(Arrays.toString(arr1));
		if (isSorted(arr2)) System.out.println(Arrays.toString(arr2));
	}
}