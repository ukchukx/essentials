import java.util.Arrays;

// Data structure for Min Heap
class PriorityQueue {
	// array to store heap elements
	private static int[] A = null;

	// stores current size of heap
	private static int size;

	// return left child of A[i]
	private static int LEFT(int i) {
		return (2 * i + 1);
	}

	// return right child of A[i]
	private static int RIGHT(int i) {
		return (2 * i + 2);
	}

	// Recursive Heapify-down algorithm. The node at index i and 
	// its two direct children violates the heap property
	private static void Heapify(int i) {
		// get left and right child of node at index i
		int left = LEFT(i);
		int right = RIGHT(i);

		int smallest = i;

		// compare A[i] with its left and right child
		// and find smallest value
		if (left < size && A[left] < A[i])
			smallest = left;

		if (right < size && A[right] < A[smallest])
			smallest = right;

		// swap with child having lesser value and
		// call heapify-down on the child
		if (smallest != i) {
			swap(A, i, smallest);
			Heapify(smallest);
		}
	}

	// Utility function to swap two indices in the array
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// Constructor (Build-Heap)
	PriorityQueue(int[] arr) {
		// allocate memory to heap and initialize it by given array
		A = Arrays.copyOf(arr, arr.length);

		// set heap capacity equal to size of the array
		size = arr.length;

		// call heapify starting from last internal node all the
		// way upto the root node
		int i = (arr.length - 2) / 2;
		while (i >= 0)
			Heapify(i--);
	}

	// function to check if heap is empty or not
	public static boolean empty() {
		return size == 0;
	}

	// function to remove element with highest priority (present at root)
	public static int pop() {
		// if heap has no elements
		if (size <= 0) {
			return -1;
		}

		int top = A[0];

		// replace the root of the heap with the last element
		// of the array
		A[0] = A[size-1];

		// decrease heap size by 1
		size--;

		// call heapify-down on root node
		Heapify(0);

		return top;
	}
}

public class OutOfPlaceHeapSort {
	// Function to perform heapsort on array A of size n
	public static void heapSort(int[] A) {
		// build a priority queue and initialize it by given array
		PriorityQueue pq = new PriorityQueue(A);

		// pop repeatedly from the heap till it becomes empty
		int i = 0;
		while(!pq.empty()) {
			A[i++] = pq.pop();
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
