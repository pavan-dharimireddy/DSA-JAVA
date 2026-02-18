// package Sorting.Bubble Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortArray(new int[]{2,5,3,6,1})));
    }
}

/*
 * Bubble Sort
 * -----------
 * Idea: Repeatedly traverse the array, swapping adjacent out-of-order pairs.
 *       After each pass, the largest element in the unsorted prefix "bubbles"
 *       to its correct position at the end.
 *
 * Time Complexity:
 *   - Worst/Average: O(n^2) (nested loops over n elements)
 *   - Best: O(n) when already sorted (due to early-exit with `swapped`)
 * Space Complexity: O(1) — in-place
 * Stability: Stable — equal elements keep relative order (adjacent swaps only)
 
*/

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Outer loop controls the number of passes.
        // After i passes, the last i elements are in their final position.
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Track if any swap happened in this pass

            // Inner loop compares adjacent elements up to the unsorted boundary (n - i - 1)
            for (int j = 0; j < n - i - 1; j++) {
                // If the next element is smaller, swap to move it leftward
                if (nums[j + 1] < nums[j]) {
                    swapped = true;
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }

            // If no swaps occurred, array is already sorted — exit early
            if (!swapped) {
                break;
            }
        }

        return nums; // Sorted in non-decreasing order
    }
}
