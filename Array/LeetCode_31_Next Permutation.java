class Solution {
    public void nextPermutation(int[] nums) {
        
        /*
        approach 1,, brute force,, time complexity --- O(N!*N)
        Steps :: 
        1.Generate all Sorted permutations by using recursion
        2.Linear search the given permutation
        3.return the next permutation to the given permutation

        */

        // approach 2 ,, time complexity ---O(N) + O(N) + O(N) = O(3N)    extra space complexity -- O(1)

        // test case :: [2,1,5,4,3,0,0]
        int n= nums.length;
        int break_index = -1;
        for(int i=n-2;i>=0;i--){  // finding the break_index
            if(nums[i]<nums[i+1]){
                break_index = i;
                break;
            }
        }
        if(break_index == -1){
            reverse_array(nums,0,n-1);
        }
        else{

        // finding the element from right which is just greater than break_index element and swapping both
        for(int i=n-1;i>break_index;i--){
            if(nums[i]>nums[break_index]){
                int temp=nums[i];
                nums[i] = nums[break_index];
                nums[break_index] = temp;
                break;
            }
        }
        
        // after swapping also still the array in increasing order
        // now reverse the array from break_index+1 to n-1 element
        reverse_array(nums,break_index+1,n-1);
        }
        
    }

    public void reverse_array(int[] arr, int start,int end){
        int temp = 0;
        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}