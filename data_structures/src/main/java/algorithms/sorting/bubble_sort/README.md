## Bubble sort
Bubble sort is a stable, in-place sorting algorithm that is named for the way smaller or larger elements “bubble” to the top of the list. Although the algorithm is simple, it is too slow and impractical for most problems even when compared to insertion sort and is not recommended when n is large.

The only significant advantage that bubble sort has over most other implementations, even quicksort, but not insertion sort, is that the ability to detect if the list is already sorted. When the list is already sorted (best-case), the complexity of bubble sort is only **O(n)**.

Each pass of bubble sort steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order. _At the end of each pass, the next largest element will “Bubble” up to its correct position._ These passes through the list are repeated until no swaps are needed, which indicates that the list is sorted. In worst case, we might end up making n – 1 passes where n is the size of the input.

**3     5     8     4     1     9    -2**   
_pass 1_  **3     5     4     1     8    -2**     _(9)_ 
_pass 2_  **3     4     1     5    -2**     _(8)_     9  
_pass 3_  **3     1     4    -2**     _(5)_     8     9  
_pass 4_  **1     3    -2**     _(4)_     5     8     9  
_pass 5_  **1    -2**     _(3)_     4     5     8     9  
_pass 6_  **-2**   _(1)_     3     4     5     8     9

The bubble sort algorithm can be easily optimized by observing that the nth pass finds the nth largest element and puts it into its final place. So, the inner loop can avoid looking at the last n-1 items when running for the nth time. 
Another optimization would be to stop the algorithm when the inner loop didn’t do any swap.

   
The worst case time complexity of bubble sort is **O(n<sup>2</sup>)**. The worst case happens when the array is reverse sorted. The best case time complexity of bubble sort is **O(n)**. The best case happens when the array is already sorted and the algorithm is modified to stop running when the inner loop didn’t do any swap.

The auxiliary space used is **O(1)** by the iterative version and **O(n)** by the recursive version for the call stack.
