## Heap sort
Heap sort is an in-place, comparison-based sorting algorithm and can be thought of as an improved selection sort as it divides the input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region by extracting the largest/smallest element and moving that to the sorted region. The improvement consists of the use of a heap data structure rather than a linear-time search to find the maximum. Heap sort does not produces a stable sort, which means that the implementation do not preserves the input order of equal elements in the sorted output. It is generally slower than other **O(nlog(n))** sorting algorithms like quicksort.

The heap sort algorithm can be divided into two parts –
*   In the first step, a heap is built out of the input data. This can be done in O(n) time.  
*   In the second step, a sorted array is created by repeatedly removing the largest/smallest element from the heap (the root of the heap), and inserting it into the array. The heap is updated (Heapify-down is called on root node) after each removal to maintain the heap property. Once all elements have been removed from the heap, we get a sorted array. This can be done in **O(nlog(n))** time we need to pop n elements and each removal involves a constant amount of work and one Heapify operation ****O(log(n))****.

How to build a heap?
--------------------
Naive solution would be to start with an empty heap and repeatedly insert each element of the input list into it. The problem with this approach is that it runs in **O(nlog(n))** time as it performs n insertions at ****O(log(n))**** cost each.

We can build a heap in O(n) time by arbitrarily putting the elements of input list into heap array. Then starting from last internal node of the heap (present at index (n-2)/2 in the array), we call heapify procedure on each node all the way up-to the root node (till index 0). _As Heapify procedure expects node’s left and right child to be heaps, we start from last internal node (as leaf nodes are already heaps) and move up level by level._

One can argue that basic heap operation of Heapify runs in ****O(log(n))**** time and we call Heapify roughly n/2 times (one for each internal node). So the complexity of above solution is **O(nlog(n))**. However, it turns out that the analysis is _not tight_.

When Heapify is called, the running time depends on how far an element might move down in tree before the process terminates. In other words, it depends on the height of the element in the heap. In the worst case, the element might go down all the way to the leaf level. Let us count the work done level by level.
*   At the bottom-most level, there are 2^(h) nodes, but we do not call heapify on any of these, so the work is 0.
*   At the next to level there are 2^(h-1) nodes, and each might move down by 1 level.
*   At the 3rd level from the bottom, there are 2^(h-2) nodes, and each might move down by 2 levels and do on..

As you can see not all heapify operations are ****O(log(n))****, this is why by doing tight analysis, we might end up getting O(n) time.
Time complexity of the above out-of-place sort is **O(nlog(n))** and auxiliary space used by the program is O(n)

### In-place sort
Heapsort can be performed in place. We can easily convert it into in-place sort by
*   using max heap instead of min heap _(to sort in ascending order)_,
*   using input array for constructing heap _(instead of using heap own storage)_

The array can be split into two parts, heap and the sorted array. As each pop operation free space at the end of the array in a binary heap, we move popped item to the free space. So, _first popped item_ (maximum element) will go at _last_ _position_ in the array, _second popped item_ (next maximum element) will go to the _second-last_ _position_ in the array and so on..finally when all items are popped from the heap, we will get array sorted in ascending order.

   
Time complexity of above solution is **O(nlog(n))** and auxiliary space used by it is **O(1)**.