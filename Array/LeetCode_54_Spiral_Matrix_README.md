# 54. Spiral Matrix

## Problem Statement

Given an `m x n` `matrix`, return all elements of the matrix in spiral order.

LeetCode Link

## Examples

### Example 1

**Input:** `matrix = [[1,2,3],[4,5,6],[7,8,9]]`  
**Output:** `[1,2,3,6,9,8,7,4,5]`

!Example 1

### Example 2

**Input:** `matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]`  
**Output:** `[1,2,3,4,8,12,11,10,9,5,6,7]`

!Example 2

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 10`
- `-100 <= matrix[i][j] <= 100`

## Approach: Layer-by-Layer Simulation

The most intuitive way to solve this problem is to simulate the spiral traversal layer by layer. We can define the boundaries of the current layer using four pointers: `top`, `bottom`, `left`, and `right`.

1.  Initialize `top = 0`, `bottom = m-1`, `left = 0`, and `right = n-1`.
2.  Create a result list to store the spiral order traversal.
3.  Start a loop that continues as long as `top <= bottom` and `left <= right`.
    - **Traverse Right:** Add elements from `matrix[top][left]` to `matrix[top][right]` to the result. After this, increment `top` as this row is now processed.
    - **Traverse Down:** Add elements from `matrix[top][right]` to `matrix[bottom][right]` to the result. After this, decrement `right`.
    - **Traverse Left:** Before traversing, check if `top <= bottom`. This is crucial for matrices with a single row or column to prevent double-counting. If the condition holds, add elements from `matrix[bottom][right]` to `matrix[bottom][left]`. Then, decrement `bottom`.
    - **Traverse Up:** Similarly, check if `left <= right`. If true, add elements from `matrix[bottom][left]` to `matrix[top][left]`. Then, increment `left`.
4.  The loop continues, shrinking the boundaries inwards, until the pointers cross, at which point all elements have been visited.

### Complexity

- **Time Complexity:** `O(M * N)` — We visit each element in the matrix exactly once.
- **Space Complexity:** `O(M * N)` — To store the output list containing all elements. The auxiliary space used for pointers is `O(1)`.

## Solution (Java)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int no_of_rows = matrix.length;
        int no_of_cols = matrix[0].length;
        int top = 0, bottom = no_of_rows - 1;
        int left = 0, right = no_of_cols - 1;
        List<Integer> l = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) l.add(matrix[top][i]);
            top++;
            for (int j = top; j <= bottom; j++) l.add(matrix[j][right]);
            right--;
            if (top <= bottom) {
                for (int k = right; k >= left; k--) l.add(matrix[bottom][k]);
                bottom--;
            }
            if (left <= right) {
                for (int m = bottom; m >= top; m--) l.add(matrix[m][left]);
                left++;
            }
        }
        return l;
    }
}
```
