## Quicksort
Quicksort is an efficient in-place sorting algorithm, which usually performs about two to three times faster than merge sort and heapsort when implemented well. Quicksort is a comparison sort, meaning that it can sort items of any type for which a _less-than_ relation is defined. In efficient implementations, it is usually not a stable sort.

Quicksort on average takes **O(nlog(n))** comparisons to sort n items. In the worst case, it makes **O(n<sup>2</sup>)** comparisons, though this behavior is very rare.

Quicksort is a divide and conquer algorithm. Like all divide and conquer algorithms, it first divides a large array into two smaller sub-arrays and then recursively sort the sub-arrays. Basically, three steps are involved in whole process –
*   **Pivot selection:** Pick an element, called a pivot, from the array (usually the leftmost or the rightmost element of the partition).
*   **Partitioning:** Reorder the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position.  
*   **Recur:** Recursively apply the above steps to the sub-array of elements with smaller values than pivot and separately to the sub-array of elements with greater values than pivot.

The base case of the recursion is arrays of size 1, which never need to be sorted.

Below diagram shows how at each step of the quicksort algorithm we choose leftmost element as pivot, partition the array across pivot and recur on two sub-arrays we get after partition process.

![](Quicksort.png)

  
Please note that the pivot selection and partitioning steps can be done in several different ways and the choice of specific implementation schemes greatly affects the algorithm’s performance.

The worst case time complexity of Quicksort is **O(n<sup>2</sup>)**. The worst case happens when the pivot happens to be the smallest or largest element in the list, or when all the elements of array are equal. This will result in most unbalanced partition as the pivot divides the array into two sub-array of sizes 0 and n – 1. If this happens repeatedly in every partition (example, we have sorted array), then each recursive call processes a list of size one less than the previous list and that will result in **O(n<sup>2</sup>)** time.

The best case time complexity of quicksort is **O(nlog(n))**. The best case happens when the pivot divides the array into two nearly equal pieces. Now each recursive call processes a list of half the size.