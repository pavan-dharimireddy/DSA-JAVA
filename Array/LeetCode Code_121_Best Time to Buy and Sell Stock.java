class Solution {
    public int maxProfit(int[] nums) {

        // approach 1, using Dynamic Programming -- remembering the past,, time complexity ---> O(N),Space complexity ---> O(1)
        int n = nums.length;
        int max_profit = 0;
        int local_min = nums[0];

        for(int i=0;i<n;i++){ // we can start from i=1, result is same
            int profit_on_that_day = nums[i]-local_min;
            max_profit = Math.max(profit_on_that_day,max_profit);
            local_min = Math.min(nums[i],local_min);
        }

        return max_profit;
        
    }
}