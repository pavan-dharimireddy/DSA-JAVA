class Solution {
    public void rotate(int[] nums, int k) {

/*
        // approach 1 ----> time complexity ---> O(k) + O(n-k) + O(k) = O(n+k),
        // extra space complexity --- O(k)
        int n = nums.length;
        k = k%n;  // if k > n, then we are avoiding unwanted rotations
        int[] arr = new int[k];

        for(int i=0;i<k;i++){
            arr[i] = nums[n-k+i];
        }

        for(int j=0;j<n-k;j++){
             nums[n-1-j] = nums[n-k-1-j];
        }

        for(int z=0;z<k;z++){
            nums[z] = arr[z];
        }
*/
        // approach 2 , time complexity ----> O(N),space complexity -- O(1)
        int n = nums.length;
        k = k%n;  // if k > n, then we are avoiding unwanted rotations
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
        

    }

    public void reverse(int[] nums,int start, int end){
        int temp = 0;
        while(start<end){

            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}