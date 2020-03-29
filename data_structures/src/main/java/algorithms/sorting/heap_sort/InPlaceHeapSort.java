
import java.util.Arrays;

// Data structure for Max Heap
public class InPlaceHeapSort {
	// return left child of A[i]
	private static int LEFT(int i) {
		return (2 * i + 1);
	}

	// return right child of A[i]
	private static int RIGHT(int i) {
		return (2 * i + 2);
	}

	// Utility function to swap two indices in the array
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// Recursive Heapify-down algorithm. The node at index i and
	// its two direct children violates the heap property
	private static void Heapify(int[] A, int i, int size) {
		// get left and right child of node at index i
		int left = LEFT(i);
		int right = RIGHT(i);

		int largest = i;

		// compare A[i] with its left and right child
		// and find largest value
		if (left < size && A[left] > A[i]){
			largest = left;
		}

		if (right < size && A[right] > A[largest]) {
			largest = right;			
		}

		// swap with child having greater value and
		// call heapify-down on the child
		if (largest != i) {
			swap(A, i, largest);
			Heapify(A, largest, size);
		}
	}

	// function to remove element with highest priority (present at root)
	public static int pop(int[] A, int size) {
		// if heap has no elements
		if (size <= 0) {
			return -1;
		}

		int top = A[0];

		// replace the root of the heap with the last element
		// of the array
		A[0] = A[size-1];

		// call heapify-down on root node
		Heapify(A, 0, size - 1);

		return top;
	}

	// Function to perform heapsort on array A of size n
	public static void heapSort(int[] A) {
		// build a priority queue and initialize it by given array
		int n = A.length;

		// Build-heap: Call heapify starting from last internal
		// node all the way upto the root node
		int i = (n - 2) / 2;
		while (i >= 0) {
			Heapify(A, i--, n);
		}

		// pop repeatedly from the heap till it becomes empty
		while (n > 0)
		{
			A[n - 1] = pop(A, n);
			n--;
		}
	}

	// Heap Sort algorithm implementation in Java
	public static void main(String[] args) {
		int[] A = { 6, 4, 7, 1, 9, -2 };

		// perform heapsort on the array
		heapSort(A);

		// print the sorted array
		System.out.println(Arrays.toString(A));
	}
}