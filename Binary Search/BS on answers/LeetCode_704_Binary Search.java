/*
// https://youtu.be/MHf6awe89xw?si=uo1n3RKOUJWeH54r
// loop
*/
class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int index = (start+end)/2;
            if(nums[index] == target){
                return index;
            }
            else if(nums[index]<target){
                start = index+1;
            }
            else{
                end = index-1;
            }
        }
        return -1;
    }
}


/*
// recursion
class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        return binarySearch(start,end,nums,target);
    }

    public int binarySearch(int start,int end, int nums[], int target){
        if(start>end){
            return -1;
        }
        else{
            int index = (start+end)/2;
            if(nums[index] == target){
                return index;
            }
            else if(nums[index]<target){
                return binarySearch(index+1,end,nums,target);
            }
            else{
                return binarySearch(start,index-1,nums,target);
            }
        }
    }
}
*/