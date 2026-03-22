import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {

/*
        //approach 1,, brute force ,, time complexity -- greater than O(N*N)
        int n = nums.length;
        int longest_consecutive = 0;
        for(int i=0;i<n;i++){
            int temp = nums[i];
            int count=1;
            while(linear_search(nums,temp+1)){
                temp++;
                count++;
            }
           longest_consecutive = Math.max(longest_consecutive,count); 

        }
        return longest_consecutive;
    }

    public boolean linear_search(int[] arr, int x){
            for(int i=0;i<arr.length;i++){
                if(arr[i]== x){
                    return true;
                }
            }
            return false;
    }
    */


/*
    // approach 2,, sorting ,, time complexity --- O(N*log(N)) + O(N)
    int n = nums.length;
    int longest_consecutive = 1;
    int previous_element = Integer.MIN_VALUE;
    int count = 0;
    Arrays.sort(nums);
    if(n==0){
        return 0;
    }
    for(int i=0;i<n;i++){
        if(nums[i]-1 == previous_element){
            count++;
            previous_element = nums[i];
        }
        else if(nums[i] != previous_element){
            count = 1;
            previous_element = nums[i];
        }
        longest_consecutive = Math.max(longest_consecutive,count);

    }
    return longest_consecutive;
*/

    // approach 3,,optimal, using HashSet , time complexity --- O(N), Space complexity ---O(N)

    int n = nums.length;
    if(n==0){
        return 0;
    }
    int longest_consecutive = 1;
    int count = 0;
    Set<Integer> set = new HashSet<>();
    for(int i=0;i<n;i++){
        set.add(nums[i]);
    }

    for(int x: set){
        if(!set.contains(x-1)){
            count++;
            int temp = x;
            while(set.contains(x+1)){
                count++;
                x = x+1;
            }
            longest_consecutive = Math.max(longest_consecutive,count);
            count = 0;
        }        
    }
    return longest_consecutive;
    }
}