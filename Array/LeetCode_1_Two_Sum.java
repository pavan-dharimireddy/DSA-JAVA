import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) { 

// the same question can be asked in different way like " return yes or no, in that case we can use two pointer technique, sort the array, left pointer at starting and right pointer at end, and if sum greater than target decrease right pointer , if sum lesser than target increase left pointer"
/*
        // approach 1 --- brute force ,,, time complexity approax --> O(N*N)
        int[] arr = new int[2];
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }

        return arr;

        */


        // approach 2 -- hashing, time complexity --- O(N*insertion time of hashmap), extra space complexity --- O(N)
        // HashMap in Java , average time taken for insertion,deletion,search is O(1) and worst case is O(N)
        int[] arr = new int[2];
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){

            if(map.containsKey(target-nums[i])){
                arr[0] = map.get(target-nums[i]);
                arr[1] = i;
                break;
            }
        
            map.put(nums[i],i);
        }
        return arr;




        
    }
}