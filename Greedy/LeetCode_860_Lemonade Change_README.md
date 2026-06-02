# 860. Lemonade Change

## Problem Statement

At a lemonade stand, each lemonade costs `$5`. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a `$5`, `$10`, or `$20` bill. You must provide the correct change to each customer so that the net transaction is that the customer pays `$5`.

Note that you do not have any change in hand at first.

Given an integer array `bills` where `bills[i]` is the bill the `i`th customer pays, return `true` if you can provide every customer with the correct change, or `false` otherwise.

## Examples

### Example 1
**Input:** `bills = [5,5,5,10,20]`  
**Output:** `true`  
**Explanation:**   
- From the first 3 customers, we collect three $5 bills in order.
- From the fourth customer, we collect a $10 bill and give back a $5.
- From the fifth customer, we give a $10 bill and a $5 bill.
- Since all customers got correct change, we output true.

### Example 2
**Input:** `bills = [5,5,10,10,20]`  
**Output:** `false`  
**Explanation:**   
- From the first two customers in order, we collect two $5 bills.
- For the next two customers in order, we collect a $10 bill and give back a $5 bill.
- For the last customer, we can not give the change of $15 back because we only have two $10 bills.
- Since not every customer received the correct change, the answer is false.

## Constraints

- `1 <= bills.length <= 10^5`
- `bills[i]` is either `5`, `10`, or `20`.

## Approach: Greedy

This problem can be optimally solved using a **Greedy** approach. We need to keep track of the count of `$5` and `$10` bills we currently have. We don't need to track `$20` bills because they cannot be used as change.

When a customer pays with a `$20` bill, we have two ways to provide `$15` in change:
1. One `$10` bill and one `$5` bill.
2. Three `$5` bills.

**Greedy Choice:** A `$5` bill is much more versatile than a `$10` bill because it can be used to make change for both `$10` and `$20` bills, whereas a `$10` bill can only be used to make change for a `$20` bill. Therefore, we should always prefer giving one `$10` and one `$5` as change for a `$20` bill if possible, saving our `$5` bills for future transactions.

### Algorithm Steps:
1. Initialize `five = 0` and `ten = 0`.
2. Iterate through each `bill` in the `bills` array:
   - If `bill == 5`, we simply increment `five`.
   - If `bill == 10`, we must give `$5` in change. If `five > 0`, we decrement `five` and increment `ten`. Otherwise, we return `false`.
   - If `bill == 20`, we first try to give one `$10` and one `$5` as change (since `$5` is more valuable to keep). If `ten > 0` and `five > 0`, we decrement both `ten` and `five`. If we don't have a `$10` bill, we try to give three `$5` bills (`five >= 3`), so we subtract `3` from `five`. If neither option is possible, we return `false`.
3. If the loop completes without failing, return `true`.

## Complexity Analysis

- **Time Complexity:** `O(N)` — We iterate through the `bills` array exactly once, where `N` is the number of customers/bills.
- **Space Complexity:** `O(1)` — We only use two integer variables (`five` and `ten`) to keep track of our cash on hand, regardless of the size of the input array.

## Solution (Java)

```java
/*
T.C -- O(N)
S.C -- O(1)
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int i : bills) {
            if (i == 5) {
                five++;
            } 
            else if (i == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } 
            else { // i == 20
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } 
                else if (five >= 3) {
                    five -= 3;
                } 
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
```
