class Solution {
    public boolean check(int[] nums) {
        
        /* approach 1

        int pivot = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            return true;
        }
        reverse(nums,0,pivot);
        reverse(nums,pivot+1,nums.length-1);
        reverse(nums,0,nums.length-1);

        for(int j=0;j<nums.length-1;j++){
            if(nums[j]>nums[j+1]){
                return false;
            }
        }
        return true;
    }

    public void reverse(int[] nums,int start,int end){
        int temp = 0;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

*/

// approach 2 --->  https://youtu.be/Vzs_vlCIFEw?si=l4vwlbuPNn3Mw5HJ

    int n = nums.length;
    int count = 1;
    for(int i=1;i<2*n;i++){
        
        if(nums[(i-1)%n] <= nums[i%n]){
                count++;
        }
        else{
            count = 1;
        }
        if(count == n){
            return true;
        }
    }

    return n==1;

    }
}