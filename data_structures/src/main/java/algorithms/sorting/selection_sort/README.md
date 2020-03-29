## Selection sort
Selection sort is an unstable, in-place sorting algorithm known for its simplicity, and it has performance advantages over more complicated algorithms in certain situations, particularly where auxiliary memory is limited. It can be implemented as a stable sort. It has **O(n<sup>2</sup>)** time complexity, making it inefficient to use on large lists. Among simple average-case **O(n<sup>2</sup>)** algorithms, selection sort almost always outperforms bubble sort and generally performs worse than the similar insertion sort.

The biggest advantage of using selection sort is that we only requires maximum n swaps (memory write) where n is the length of the input. insertion sort, on the other hand, takes **O(n<sup>2</sup>)** number of writes. This can be very important if memory write operation is significantly more expensive than memory read operation, such as with Flash memory, where every write lessens the lifespan of the memory.

The idea is to divide the array into two subsets – sorted sublist and unsorted sublist. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest _(or largest, depending on sorting order)_ element in the unsorted sublist, swapping it with the leftmost unsorted element _(putting it in sorted order)_, and moving the sublist boundaries one element to the right. Below example explains it all –
 
**3  5  8  4  1  9 -2**  
_i = 0_      _(-2)_ **5  8  4  1  9  3**   
_i = 1_      -2  _(1)_  **8  4  5  9  3**  
_i = 2_      -2  1  _(3)_  **4  5  9  8**  
_i = 3_      -2  1  3  _(4)_  **5  9  8**  
_i = 4_      -2  1  3  4  _(5)_  **9  8**  
_i = 5_      -2  1  3  4  5  _(8)_  **9**  


Both worst and best case time complexity of selection sort is **O(n<sup>2</sup>)** and auxiliary space used by it is **O(1)**.
