// import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
    
    /*
        // approach 1, brute force,,, time complexity -- O(N), space complexity --- O(N)
        int n = nums.length;
        int[] arr = new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                arr[j] = nums[i];
                j++;
            }
        }
        // System.out.println(Arrays.toString(arr));
        for(int i=0;i<n;i++){        
                nums[i] = arr[i];             
            }
        */
        
        // approach 2, optimal, time complexity --- O(N), Space complexity -- O(1)
        // https://www.youtube.com/watch?v=wvcQg43_V8U&t=4s

        int j = -1;
        //place the pointer j:
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        //no non-zero elements:
        if (j == -1) return;

        //Move the pointers i and j
        //and swap accordingly:
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                //swap a[i] & a[j]:
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
        
        

    /*
    int n = nums.length;
    int i=0;
    int j=1;
    while(j<n){
        if(nums[i]==0 && nums[j]==0){
            j++;
        }
        else if(nums[i]==0 && nums[j]!=0){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j++;
        }
        else if(nums[i]!=0 && nums[j]==0){
            i++;
            j++;
        }
        else{
            i++;
            j++;
        }
    }
    */
        
    }
}