# 229. Majority Element II

## Problem Statement

Given an integer array of size `n`, find all elements that appear more than `⌊ n/3 ⌋` times.

## Examples

### Example 1
**Input:** `nums = [3,2,3]`  
**Output:** `[3]`  

### Example 2
**Input:** `nums = [1]`  
**Output:** `[1]`  

### Example 3
**Input:** `nums = [1,2]`  
**Output:** `[1,2]`  

## Constraints

- `1 <= nums.length <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`

## Approaches

### Approach 1: HashMap (Using Extra Space)
Iterate through the array and use a `HashMap` to store the frequency of each element. After populating the map, iterate through its entries and add any element whose frequency is strictly greater than `n / 3` to the result list.
- **Time Complexity:** O(N) — We traverse the array once to build the map, and then traverse the map. Map insertions/lookups take O(1) on average.
- **Space Complexity:** O(N) — In the worst case, all elements are unique, requiring O(N) space in the HashMap.

### Approach 2: Boyer-Moore Voting Algorithm (Optimal)
Because we are looking for elements that appear *more* than `⌊ n/3 ⌋` times, there can be at most **two** such elements in the array. We can find them using an extended version of the Boyer-Moore Voting Algorithm in two phases:

1. **Phase 1 (Candidate Selection):** Iterate through the array maintaining two potential candidates and their respective counts. If we see a candidate, we increment its count. If we see a new number and a count is zero, we replace the candidate. If the current number matches neither candidate, we decrement both counts.
2. **Phase 2 (Candidate Validation):** The candidates found in Phase 1 are not guaranteed to be the majority elements; they are just the most viable candidates. We must iterate through the array a second time to count their actual frequencies and check if they strictly exceed `⌊ n/3 ⌋`.

- **Time Complexity:** O(N) — We traverse the array exactly twice (O(2N)), which simplifies to O(N).
- **Space Complexity:** O(1) — We only use a few integer variables for counting and tracking candidates.

## Solution (Java)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int n = nums.length;

        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        // Phase 1: find possible candidates
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && element2 != nums[i]) {
                element1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && element1 != nums[i]) {
                element2 = nums[i];
                count2 = 1;
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: recount actual frequencies
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == element1) count1++;
            else if (num == element2) count2++;
        }

        int mini = n / 3 + 1;
        if (count1 >= mini) l.add(element1);
        
        // The check 'element1 != element2' is an excellent defensive 
        // programming practice to protect the final output contract.
        if (count2 >= mini && element1 != element2) l.add(element2);

        return l;
    }
}
```
