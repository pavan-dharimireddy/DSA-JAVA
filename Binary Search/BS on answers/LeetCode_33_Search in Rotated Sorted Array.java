/*
https://youtu.be/5qGrJbHhqFs?si=pZCXoYgsbVLKxmLk
*/

/*
approach 1 --> linear search , T.C -- O(N)

public class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
*/

/*
Time Complexity (T.C):

Each iteration halves the search space → O(log n)

Space Complexity (S.C):

Uses a constant amount of extra variables → O(1)
*/

public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;    //left pointer
        int high = nums.length - 1;    //right pointer

        while (low <= high) {    //binary search loop over rotated sorted array
            int mid = (low + high)/2;

            if (nums[mid] == target) {    //found target at mid
                return mid;    //return index
            }
            else if (nums[low] <= nums[mid]) {    //left half [low..mid] is strictly sorted
            // nums[low] < nums[mid] --> fails at [3,1] target = 1
                if (target >= nums[low] && target < nums[mid]) {    //target lies inside left sorted half
                    high = mid - 1;    //discard right half
                }
                else {    //target not in left sorted half
                    low = mid + 1;    //search right half
                }
            }
            else {    //right half [mid..high] is sorted (or left half has equal values)
                if (target > nums[mid] && target <= nums[high]) {    //target lies inside right sorted half
                    low = mid + 1;    //discard left half
                }
                else {    //target not in right sorted half
                    high = mid - 1;    //search left half
                }
            }
        }

        return -1;    //target not found
    }
}

/*
Great catch. Your code fails for nums = [3,1], target = 1 because of this condition:
Javaelse if (nums[low] < nums[mid]) { ... }
On the first (and only) iteration:

low = 0, high = 1, mid = 0
nums[low] = 3, nums[mid] = 3

The check nums[low] < nums[mid] is false (3 < 3 is false), so your code incorrectly assumes the right half is sorted and executes the else branch. There, the condition:
Javaif (target > nums[mid] && target <= nums[high])
becomes if (1 > 3 && 1 <= 1) → false, and you set high = mid - 1 → high = -1, exit the loop, and return -1, even though target is at index 1.


*/