## Kadane's algorithm
Problem: 
Given an array of integers, find contiguous subarray within it which has the largest sum.
Eg:
  
**Input:**  {-2, 1, -3, 4, -1, 2, 1, -5, 4}  
   
**Output:** Subarray with the largest sum is {4, -1, 2, 1} with sum 6.

We can easily solve this problem in linear time using kadane’s algorithm. The idea is to maintain maximum (positive sum) sub-array "ending" at each index of the given array. This subarray is either empty (in which case its sum is zero) or consists of one more element than the maximum subarray ending at the previous index.

   
The time complexity of the solution is O(n) and auxiliary space used by the program is O(1).

Because of the way this algorithm uses optimal substructures (the maximum subarray ending at each position is calculated in a simple way from a related but smaller and overlapping subproblem: the maximum subarray ending at the previous position) this algorithm can be viewed as a simple example of Dynamic Programming.
