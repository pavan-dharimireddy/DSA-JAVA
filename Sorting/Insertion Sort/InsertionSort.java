// package Sorting.Insertion Sort;

import java.util.Arrays;



public class InsertionSort {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortArray(new int[]{2,5,3,6,1})));
    }
}


/*
 * Insertion Sort
 * --------------
 * Idea: Build the sorted portion of the array one element at a time.
 *       For each element, insert it into its correct position among the
 *       previously sorted elements by shifting larger elements to the right.
 *
 * Time Complexity:
 *   - Worst/Average: O(n^2) (nested loop for shifting)
 *   - Best: O(n) when array is already sorted (only one comparison per element)
 * Space Complexity: O(1) — in-place
 * Stability: Stable — equal elements retain their relative order
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Start from index 1 because a single element (index 0) is trivially sorted
        for (int i = 1; i < n; i++) {
            int temp = nums[i]; // Current element to insert
            int j = i - 1;

            // Shift elements of the sorted portion to the right until correct position is found
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }

            // Place the current element in its correct position
            nums[j + 1] = temp;
        }

        return nums; // Sorted in non-decreasing order
    }
}