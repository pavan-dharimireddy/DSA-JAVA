/*
https://youtu.be/hjR1IYVx9lY?si=cjqDufmi_WY_gYU2
// approach 1 "linear search", T.C -- O(N)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        // Variables to store the first and last occurrence of target
        int first = -1;
        int last = -1;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // If we find the target
            if (nums[i] == target) {

                // If 'first' is already set, update 'last'
                if (first != -1) {
                    last = i;
                }
                // If this is the first time seeing the target
                else {
                    first = i;  // both first and last are this index initially
                    last = i;
                }
            }
        }

        // Return the range [first, last]
        // If target was never found, both remain -1
        return new int[]{first, last};
    }
}
*/

/*
Time Complexity (T.C):

lowerBound: O(log n)
upperBound: O(log n)
searchRange: O(log n) overall (two binary searches)

Space Complexity (S.C):

O(1) auxiliary space (uses a constant number of variables)
*/


/*
Time Complexity (T.C):

lowerBound: O(log n)
upperBound: O(log n)
searchRange: O(log n) overall (two binary searches)

Space Complexity (S.C):

O(1) auxiliary space (uses a constant number of variables)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums,target);    //find first index where nums[i] >= target
        if (lb == nums.length || nums[lb] != target) {    //if target not present at lowerBound (absent in array)
            return new int[]{-1, -1};    //return not found range
        } else {
            return new int[]{lb, upperBound(nums,target)};    //return [firstIndex, lastIndex], lastIndex = upperBound - 1 (implemented inside)
        }
    }

    public int lowerBound(int[] nums, int target) {
        int start = 0;    //left pointer for binary search
        int end = nums.length - 1;    //right pointer for binary search
        int start_index = nums.length;    //default to insertion point at end if all elements < target

        while (start <= end) {    //standard binary search loop
            int mid = (start + end) / 2;    //compute mid index
            if (nums[mid] >= target) {    //mid could be first position >= target
                start_index = mid;    //record candidate lower bound
                end = mid - 1;    //search left half to find earlier occurrence
            } else {
                start = mid + 1;    //search right half if mid value < target
            }
        }
        return start_index;    //first index i such that nums[i] >= target (or nums.length if none)
    }

    public int upperBound(int[] nums, int target) {
        int start = 0;    //left pointer for binary search
        int end = nums.length - 1;    //right pointer for binary search
        int end_index = nums.length;    //default to insertion point at end if all elements <= target

        while (start <= end) {    //standard binary search loop
            int mid = (start + end) / 2;    //compute mid index
            if (nums[mid] > target) {    //found an index strictly greater than target
                end_index = mid;    //record candidate upper bound (first > target)
                end = mid - 1;    //try to find an earlier index > target
            } else {
                start = mid + 1;    //otherwise move right (nums[mid] <= target)
            }
        }
        return end_index - 1;    //last index where nums[i] == target is upperBound - 1
    }
}
*/

/*
Time Complexity (T.C):

firstOccurance: O(log n)
lastOccurance: O(log n)
searchRange: O(log n) overall (two binary searches)

Space Complexity (S.C):

O(1) auxiliary space (uses only a constant number of variables)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurance(nums, target);    //find first occurrence index using binary search
        if (first == -1) {    //if first occurrence not found, target is absent
            return new int[]{-1, -1};    //return [-1, -1] when target doesn't exist
        }
        int last = lastOccurance(nums, target);    //find last occurrence index using binary search
        return new int[]{first, last};    //return the range [first, last]
    }

    public int firstOccurance(int[] nums, int target) {
        int low = 0;    //left pointer for binary search
        int high = nums.length - 1;    //right pointer for binary search
        int first_index = -1;    //stores the best found index of first occurrence
        while (low <= high) {    //standard binary search loop
            int mid = (low + high) / 2;    //compute mid index
            if (nums[mid] == target) {    //found target at mid, try to go left to find earlier occurrence
                first_index = mid;    //record current mid as potential first index
                high = mid - 1;    //shrink to left half to find earlier target
            }
            else if (nums[mid] > target) {    //mid value too large, target must be on left side
                high = mid - 1;    //move high left
            }
            else {    //nums[mid] < target
                low = mid + 1;    //move low right
            }
        }
        return first_index;    //final first occurrence index or -1 if not found
    }

    public int lastOccurance(int[] nums, int target) {
        int low = 0;    //left pointer for binary search
        int high = nums.length - 1;    //right pointer for binary search
        int last_index = -1;    //stores the best found index of last occurrence
        while (low <= high) {    //standard binary search loop
            int mid = (low + high) / 2;    //compute mid index
            if (nums[mid] == target) {    //found target at mid, try to go right to find later occurrence
                last_index = mid;    //record current mid as potential last index
                low = mid + 1;    //shrink to right half to find later target
            }
            else if (nums[mid] > target) {    //mid value too large, target must be on left side
                high = mid - 1;    //move high left
            }
            else {    //nums[mid] < target
                low = mid + 1;    //move low right
            }
        }
        return last_index;    //final last occurrence index or -1 if not found
    }
}