/*
  Selection Sort, T.C ---> O(n*n)
  --------------
  Idea: Repeatedly select the smallest element from the unsorted region
        and swap it into its correct position at the start.
 
https://youtu.be/HGk_ypEuS24?si=N4VtYRKxwqN-BSKz

*/

// package Sorting;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortArray(new int[]{2,5,3,6,1})));
    }
}


 
class Solution {
    public int[] sortArray(int[] nums) {
        // Iterate over each position where we will place the next smallest element.
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int smallest = i; // index of the smallest element found in nums[i..n-1]

            // Find the index of the smallest element in the unsorted suffix [i+1..n-1]
            for(int j=i+1;j<n;j++){
                if(nums[j] < nums[smallest]){
                    smallest = j;
                }
            }

     // Swap only if a smaller element was found (avoids unnecessary writes)
            if(smallest != i){
                int temp = nums[i];
                nums[i] = nums[smallest];
                nums[smallest] = temp;
            }
        }
         // Array is now sorted in non-decreasing order
        return nums;
    }
}

