# Priority Queue
The **Priority Queue** ADT can be formally defined by the following set of functions:
* insert(element): Add element to the **Priority Queue**
* peek(): Look at the highest priority element in the **Priority Queue**
* pop(): Remove the highest priority element from the **Priority Queue**

Although we are free to implement a **Priority Queue** any way we want (because it is an ADT), you'll soon realize that the data structures we've learned about so far make it a bit difficult to guarantee a good worst-case time complexity for both insertion and removal. We could theoretically use a sorted **Linked List** to back our **Priority Queue**, which would result in _O(1)_ peeking and removing (we would have direct access to the highest priority element), but insertion would be _O(n)_ to guarantee that our list remains sorted (we would have to scan through the sorted list to find the correct insertion site). Likewise, we could theoretically use an unsorted **Linked List** to back our **Priority Queue**, which would result in _O(1)_ insertion (we could just insert at the head or tail of the list), but peeking and removing would be _O(n)_ (we would have to scan through the unsorted list to find the highest priority element). If you were to implement this using a sorted or unsorted **Array**, the worst-case time complexities would be the same as for a sorted or unsorted **Linked List**.

It turns out that the **Heap** is typically used to implement the **Priority Queue** ADT that guarantees _O(1)_ peeking and _O(log n)_ insertion and removal in the worst case.