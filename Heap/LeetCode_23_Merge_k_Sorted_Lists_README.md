# 23. Merge k Sorted Lists

## Problem Statement

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

## Approaches

### Approach 1: Brute Force (Sorting) - Currently Implemented

This approach involves extracting all node values from the given `k` linked lists, storing them in a dynamic array (like an `ArrayList`), sorting the array, and then creating a completely new sorted linked list from the sorted values.

- **Time Complexity:** `O(N log N)` where `N` is the total number of nodes across all `k` lists. Collecting all values takes `O(N)`, sorting the array takes `O(N log N)`, and iterating through the sorted array to create the new list takes `O(N)`.
- **Space Complexity:** `O(N)`. We use an `ArrayList` to store all `N` values and we allocate entirely new nodes to construct the final linked list.

### Approach 2: Priority Queue (Min-Heap) - Optimal

Since the input lists are already individually sorted, we can use a Min-Heap (`PriorityQueue` in Java) to keep track of the smallest current element among the heads of all `k` lists.
1. Insert the head nodes of all `k` lists into the Min-Heap.
2. Extract the minimum node from the heap and append it to the merged list.
3. If the extracted node has a `next` node, insert that `next` node into the Min-Heap.
4. Repeat steps 2 & 3 until the heap is empty.

- **Time Complexity:** `O(N log k)`. Each insertion and extraction operation on the Min-Heap of size `k` takes `O(log k)` time. We perform this for all `N` nodes.
- **Space Complexity:** `O(k)` for the Min-Heap. By manipulating the pointers of the existing linked list nodes to form the result, we avoid the `O(N)` extra space required to create new nodes.

### Approach 3: Divide and Conquer - Optimal

We can merge the lists in pairs. Merge list 1 and list 2, list 3 and list 4, and so on. Then merge the resulting lists in pairs again, halving the number of lists in each iteration until only one sorted list remains. This uses the standard "Merge Two Sorted Lists" algorithm as a subroutine.

- **Time Complexity:** `O(N log k)`. The outer loop runs `log k` times (since we halve the number of lists each time). In each iteration, we process all `N` nodes across all the pairwise merges.
- **Space Complexity:** `O(1)` auxiliary space. We can perform the merges in-place by adjusting node pointers, without creating new nodes or using a Priority Queue. (Note: A recursive implementation would use `O(log k)` call stack space).

## How to Run

This solution is designed to be run on the LeetCode platform. To run it locally, you would need to implement a driver `main` method that constructs the `ListNode` objects, populates them into an array, and passes them to the `mergeKLists` method.
