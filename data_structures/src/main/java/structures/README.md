# Trees
Formally, a graph is, by definition, a collection of nodes (or vertices) and edges connecting these nodes. A tree is defined as a graph without any undirected cycles (i.e., cycles that would come about if we replaced directed edges with undirected edges) nor any unconnected parts. 

For a graph T to be considered a tree, it must follow all of the following constraints (which can be proven to be equivalent constraints):
* T is connected and has no undirected cycles (i.e., if we made T's directed edges undirected, there would be no cycles)
* T is acyclic, and a simple cycle is formed if any edge is added to T
* T is connected, but is not connected if any single edge is removed from T
* There exists a unique simple path connecting any two vertices in T

If T has n vertices (where n is a finite number), then the above statements are equivalent to the following two conditions:
* T is connected and has n−1 edges
* T has no simple cycles and has n−1 edges

There are two classes of trees: rooted and unrooted.

In a rooted tree, a given node can have a single parent node above it and can have any number of children nodes below it. Just like with a family tree, all nodes that appear along the path going upward from a given node are considered that node's ancestors, and all nodes that appear along any path going downward from a given node are considered that node's descendants. There is a single node at the top of the tree that does not have a parent, which we call the root, and there can be any number of nodes at the bottom of the tree that have no children, which we call leaves. All nodes that have children are called internal nodes.

In an unrooted tree, there is no notion of parents or children. Instead, a given node has neighbors. Any nodes with just a single neighbor is considered a leaf and any node with more than one neighbor is considered an internal node.

## Traversal
Because we typically only keep track of the root node, to traverse all of the nodes in a rooted binary tree, there are four traversal algorithms: pre-order, in-order, post-order, and level-order. In all four, the verb "visit" simply denotes whatever action we perform when we are at a given node u

![](tree.png)

In a **pre-order** traversal, we first visit the current node, then we recurse on the left child (if one exists), and then we recurse on the right child (if one exists). Put simply, **VLR (Visit-Left-Right)**. In the example above, a pre-order traversal starting at the root would visit the nodes in the following order: 1 2 3 4 5

In an **in-order** traversal, we first recurse on the left child (if one exists), then we visit the current node, and then we recurse on the right child (if one exists). Put simply, **LVR (Left-Visit-Right)**. In the example above, an in-order traversal starting at the root would visit the nodes in the following order: 2 1 4 3 5

In a **post-order** traversal, we first recurse on the left child (if one exists), then we recurse on the right child (if one exists), and then we visit the current node. Put simply, **LRV (Left-Right-Visit)**. In the example above, a post-order traversal starting at the root would visit the nodes in the following order: 2 4 5 3 1

In a **level-order** traversal, we visit nodes level-by-level (where the root is the "first level," its children are the "second level," etc.), and on a given level, we visit nodes left-to-right. In the example above, a level-order traversal starting at the root would visit the nodes in the following order: 1 2 3 4 5