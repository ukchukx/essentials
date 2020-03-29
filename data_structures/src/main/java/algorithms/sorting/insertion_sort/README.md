## Insertion sort
Insertion sort is stable, in-place sorting algorithm that builds the final sorted array one item at a time. 
It is not very best in terms of performance but it is more efficient in practice than most other simple **O(n2)** algorithms such as selection sort or bubble sort.

It works by dividing the array into two subsets – sorted subset and unsorted subset. Initally sorted subset consists of only one first element at index 0. Then for each iteration, insertion sort removes next element from the unsorted subset, finds the location it belongs within the sorted subset, and inserts it there. It repeats until no input elements remain. Below example explains it all:
  
_i = 1_ \[ 3 **(_8_) 5 4 1 9 -2** \]  
_i = 2_ \[ 3 8 **(_5_) 4 1 9 -2** \]   
_i = 3_ \[ 3 5 8 **(_4_) 1 9 -2** \]   
_i = 4_ \[ 3 4 5 8 **(_1_) 9 -2** \]  
_i = 5_ \[ 1 3 4 5 8 **(_9_) -2** \]  
_i = 6_ \[ 1 3 4 5 8 9 **(_-2_)** \]  
 \[ \-2 1 3 4 5 8 9 \]  

The worst case time complexity of insertion sort is **O(n<sup>2</sup>)**. The worst case happens when the array is reverse sorted. The best case time complexity of insertion sort is **O(n)**. The best case happens when the array is already sorted.

The auxiliary space used is **O(1)** by the iterative version and **O(n)** by the recursive version for the call stack.