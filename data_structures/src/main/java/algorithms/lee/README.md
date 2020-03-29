## Lee's algorithm
Problem: 
Given a maze in the form of the binary rectangular matrix, find length of the shortest path in a maze from given source to given destination.

The path can only be constructed out of cells having value 1 and at any given moment, we can only move one step in one of the four directions. The Valid moves are:
  
**Go Up:** (x, y) –> (x – 1, y)  
**Go Left:** (x, y) –> (x, y – 1)  
**Go Down:** (x, y) –> (x + 1, y)  
**Go Right:** (x, y) –> (x, y + 1)

For example, consider below binary matrix. If source = (0, 0) and destination = (7, 5), the shortest path from source to destination has length 12.

\[**1** **1** **1** 1 1 0 0 1 1 1\]  
\[0  1 **1**  1  1  1  0  1  0  1\]  
\[0  0  **1**  0  1  1  1  0  0  1\]  
\[1  0  **1** **1**  1  0  1  1  0  1\]  
\[0  0  0  **1**  0  0  0  1  0  1\]  
\[1  0  1  **1** **1**  0  0  1  1  0\]  
\[0  0  0  0  **1**  0  0  1  0  1\]  
\[0  1  1  1  **1** **1**  1  1  0  0\]  
\[1  1  1  1  1  0  0  1  1  1\]  
\[0  0  1  0  0  1  1  0  0  1\]  
  
The **Lee algorithm** is one possible solution for maze routing problems based on Breadth-first search. It always gives an optimal solution, if one exists, but is slow and requires considerable memory. Below is the complete algorithm –  
1.  Create an empty queue and enqueue source cell having distance 0 from source (itself) and mark it as visited  
2.  do till queue is not empty
    *   Pop front node from the queue  
    *   If the popped node is destination node, then return its distance  
    *   else for each of 4 adjacent cells of current cell, we enqueue each valid cell into the queue with +1 distance and mark them as visited  
3.  If all the nodes in the queue is processed and destination is not reached, then return false

Time complexity of above solution is **O(MN)**.