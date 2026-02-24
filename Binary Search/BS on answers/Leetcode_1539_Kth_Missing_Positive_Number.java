/* approach 1 --- My Brute Force
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int current = 0; // pointer into the sorted array 'arr'
        int i = 1;       // current positive integer we are checking (starts from 1)

        // We will keep moving forward until we've found k missing positive numbers
        while (k > 0) {

            // If 'i' exists in the array at position 'current'
            if (current < arr.length && arr[current] == i) {
                // 'i' is not missing — advance both pointers
                current++;
                i++;
            } else {
                // 'i' is missing (either we've exhausted the array or arr[current] != i)
                // Count this as one missing number
                i++;
                k--;
            }
        }

        // We incremented 'i' one extra time after counting the k-th missing number,
        // so the k-th missing number is 'i - 1'
        return i - 1;
    }
}
*/

/* Approach 2  -- Brute Force T.C -- O(N) , S.C -- O()
class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        for (int x : arr) {
            if (x <= k) {
                // If the current array value is <= current k,
                // it means this value "occupies" one of the positive integers
                // that could have been missing. So the k-th missing number
                // shifts to the right by 1.
                k++;
            } else {
                // As soon as we find an array value > k,
                // it means the k-th missing number is not in the array
                // and is exactly 'k'.
                break;
            }
        }
    
        return k;
    }
}
*/

/* Approach 3 -- Binary Search , T.C -- O(log(N)) , S.C -- O(1) */

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low<=high){
            int mid = (high+low)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high+1+k;
    }
}