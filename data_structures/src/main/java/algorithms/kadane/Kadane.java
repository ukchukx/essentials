class Kadane {
	// Function to find contiguous sub-array with the largest sum
	// in given set of integers (handles negative numbers as well)
	public static int kadaneNeg(int[] A) {
		// stores maximum sum sub-array found so far
		int maxSoFar = A[0];

		// stores maximum sum of sub-array ending at current position
		int maxEndingHere = A[0];

		// traverse the given array
		for (int i = 1; i < A.length; i++) {
			// update maximum sum of sub-array "ending" at index i (by adding
			// current element to maximum sum ending at previous index i-1)
			maxEndingHere = maxEndingHere + A[i];

			// maximum sum is should be more than the current element
			maxEndingHere = Integer.max(maxEndingHere, A[i]);

			// update result if current sub-array sum is found to be greater
			maxSoFar = Integer.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
	}

	// main function
	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, A1 = { -8, -3, -6, -2, -5, -4 };

		System.out.println("The sum of contiguous sub-array in A with the largest sum is " + kadane(A));
		System.out.println("The sum of contiguous sub-array in A1 with the largest sum is " + kadane(A1));
	}
}