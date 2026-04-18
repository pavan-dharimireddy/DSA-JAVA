/* Approach 1 -- Brute Force  T.C -- O(N*N), S.C --- O(1) 

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0; // Tracks the maximum length of a valid subarray found so far

        // Fix the starting index of the window at i
        for (int i = 0; i < nums.length; i++) {
            int zeros_count = 0; // Count of zeros in the current window [i..j]

            // Expand the window by moving j to the right
            for (int j = i; j < nums.length; j++) {
                // If we see a zero, it would need to be flipped
                if (nums[j] == 0) {
                    zeros_count++;
                }

                // If the number of zeros to flip is within the allowed limit k,
                // update the maximum window length
                if (zeros_count <= k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                } else {
                    // As soon as zeros exceed k, extending j further will only worsen it,
                    // so we break early for this i
                    break;
                }
            }
        }

        return maxlen;
    }
}
*/

/* Approach 2 -- sliding window and two pointer , T.C - O(2N),S.C - O(1) 
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max_len = 0;
        int l=0,r=0;
        int zeros_count = 0;
        while(r < nums.length){
            if(nums[r]== 0){
                zeros_count++;
            }

            if(zeros_count <= k){
                max_len = Math.max(r-l+1,max_len);
            }
            while(zeros_count > k){
                if(nums[l] == 0){
                    zeros_count--;
                }
                l++;
            }
        r++;
        }
    return max_len;
    }
}

*/

/*
Approach 3 -- sliding window and two pointer removing while loop, T.C - O(N),S.C - O(1) 
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max_len = 0;
        int l=0,r=0;
        int zeros_count = 0;
        while(r < nums.length){
            if(nums[r]== 0){
                zeros_count++;
            }

            if(zeros_count <= k){
                max_len = Math.max(r-l+1,max_len);
            }
            
            if(zeros_count > k){
                if(nums[l] == 0){
                    zeros_count--;
                }
                l++;
            }
        r++;
        }
    return max_len;
    }
}