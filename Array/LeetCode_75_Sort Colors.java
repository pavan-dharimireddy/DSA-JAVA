class Solution {
    public void sortColors(int[] nums) {
        
        // approach 1, brute force, applying sorting algo ,, time complexity -- O(Nlog(N))
/* 
        // approach 2, time complexity ---- O(2N)
            int n = nums.length;
            int count0 = 0,count1=0,count2 = 0;
            for(int x: nums){
                if(x==0){
                    count0++;
                }
                else if(x==1){
                    count1++;
                }
                else{
                    count2++;
                }
            }
            int i=0;
            for(;count0 !=0;count0--){
                nums[i] = 0;
                i++;
            }
            for(;count1 !=0;count1--){
                nums[i] = 1;
                i++;
            }
            for(;count2 !=0;count2--){
                nums[i] = 2;
                i++;
            }
*/
        /* approach 2 with modification
        int n = nums.length;
        int[] count_arr = new int[3];

        for(int i=0;i<n;i++){
            count_arr[nums[i]]++;
        }
        
        int i=0;
        for(int k=0;k<count_arr.length;k++){
           int j = count_arr[k];
           while(j!=0){
            nums[i] = k;
            j--;
            i++;
           }
        }
        */

    // approach 3, dutch national flag algo , time complexity --- O(N)
    // https://youtu.be/tp8JIuCXBaU?si=XfaoTDBts2KfsWV5

    int n = nums.length;
    int low = 0,mid=0,high = n-1;

    while(mid<=high){
            if(nums[mid] == 0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,high);
                    high--;
                }
            
    }

    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}