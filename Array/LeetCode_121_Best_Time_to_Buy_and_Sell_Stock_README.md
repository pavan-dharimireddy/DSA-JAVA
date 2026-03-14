# 121. Best Time to Buy and Sell Stock

## Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

LeetCode Link

## Examples

### Example 1
**Input:** `prices = [7,1,5,3,6,4]`
**Output:** `5`
**Explanation:** Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

### Example 2
**Input:** `prices = [7,6,4,3,1]`
**Output:** `0`
**Explanation:** In this case, no transactions are done and the max profit = 0.

## Constraints
- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

## Approaches

### Approach 1: Dynamic Programming / One Pass
We can maintain the minimum price seen so far (`local_min`) and calculate the potential profit for each day. If the potential profit is greater than our `max_profit`, we update it.
- **Time Complexity:** O(N)
- **Space Complexity:** O(1)

## Solution (Java)

```java
class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int max_profit = 0;
        int local_min = nums[0];

        for (int i = 0; i < n; i++) {
            int profit_on_that_day = nums[i] - local_min;
            max_profit = Math.max(profit_on_that_day, max_profit);
            local_min = Math.min(nums[i], local_min);
        }
        return max_profit;
    }
}
```
