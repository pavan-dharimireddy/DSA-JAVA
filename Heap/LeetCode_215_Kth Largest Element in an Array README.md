# 215. Kth Largest Element in an Array

## Problem Statement

Given an integer array `nums` and an integer `k`, return the `k`th largest element in the array.

Note that it is the `k`th largest element in the sorted order, not the `k`th distinct element.

LeetCode Link: Kth Largest Element in an Array

## Constraints

- `1 <= k <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

## Approaches

### Approach 1: Sorting
Sort the array in ascending order and return the element at the target index `n - k`.
- **Time Complexity:** `O(N log N)` — Dominated by the sorting algorithm.
- **Space Complexity:** `O(1)` — Modifying the array in-place (assuming standard in-place sorts like Dual-Pivot Quicksort, which may use `O(log N)` stack space).

### Approach 2: Max-Heap
Insert all elements of the array into a Max-Heap (using a `PriorityQueue` with reverse order). Then, extract the maximum element `k` times. The `k`th extracted element is the result.
- **Time Complexity:** `O(N log N)` — Traversing the array and adding elements to the heap takes time, and polling elements adds to it.
- **Space Complexity:** `O(N)` — Extra space required to store all `N` elements in the Priority Queue.

### Approach 3: Min-Heap (Size K)
Maintain a Min-Heap of size `K`. Insert the first `K` elements into the heap. For the remaining `N - K` elements, if the current element is greater than the root of the Min-Heap (the smallest of the `K` largest elements seen so far), remove the root and insert the current element. After processing all elements, the root of the Min-Heap is the `K`th largest element.
- **Time Complexity:** `O(N log K)` — We traverse the array of `N` elements, and in the worst case, perform heap operations that take `O(log K)` time each.
- **Space Complexity:** `O(K)` — The Priority Queue only ever stores a maximum of `K` elements.

### Approach 4: QuickSelect (Optimal)
An application of the QuickSort partition scheme. We pick a random pivot, partition the array into elements smaller and larger than the pivot, and determine the final sorted index of the pivot. If the pivot's index matches the target index for the `k`th largest element (which is `k - 1` when searching for the largest), we return it. Otherwise, we recursively search only the left or right partition.
- **Time Complexity:** `O(N)` — Average case. Assuming the array divides into two roughly equal parts, the search range is reduced by half each time: `O(N + N/2 + N/4 + ...) = O(N)`. In the worst case (already sorted array with bad pivot), it falls to `O(N^2)`, but using a random pivot makes this extremely unlikely.
- **Space Complexity:** `O(1)` — The partitioning modifies the input array completely in-place.

## Solution (Java)

```java
import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
         // Return -1, if the Kth largest element does not exist
        if (k > nums.length) return -1;

        // Pointers to mark the part of working array
        int left = 0, right = nums.length - 1;

        // Until the Kth largest element is found
        while (true) {
            // Get the pivot index
            int pivotIndex = randomIndex(left, right);

            // Update the pivotIndex
            pivotIndex = partitionAndReturnIndex(nums, pivotIndex, left, right);

            // If Kth largest element is found, return
            if (pivotIndex == k - 1) return nums[pivotIndex];

            // Else adjust the end pointers in array
            else if (pivotIndex > k - 1) right = pivotIndex - 1;
            else left = pivotIndex + 1;
        }
    }
    
    private Random rand = new Random();

    // Function to get a random index
    private int randomIndex(int left, int right) {
        // Length of the array
        int len = right - left + 1;
        
        // Return a random index from the array
        return rand.nextInt(len) + left;
    }

    // Function to perform the partition and return the updated index of pivot
    private int partitionAndReturnIndex(int[] nums, int pivotIndex, int left, int right) {
        int pivot = nums[pivotIndex]; // Get the pivot element
        
        // Swap the pivot with the left element
        int temp = nums[left];
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = temp;
        
        int ind = left + 1; // Index to mark the start of right portion
        
        // Traverse on the array
        for (int i = left + 1; i <= right; i++) {
            
            // If the current element is greater than the pivot
            if (nums[i] > pivot) {
                // Place the current element in the left portion
                temp = nums[ind];
                nums[ind] = nums[i];
                nums[i] = temp;
                
                // Move the right portion index
                ind++;
            }
        }
        
        // Place the pivot at the correct index
        temp = nums[left];
        nums[left] = nums[ind - 1];
        nums[ind - 1] = temp;
        
        return ind - 1; // Return the index of pivot now
    }
}
```
