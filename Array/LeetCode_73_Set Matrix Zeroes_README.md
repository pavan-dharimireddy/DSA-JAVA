# 73. Set Matrix Zeroes

## Problem Statement

Given an `m x n` integer matrix `matrix`, if an element is `0`, set its entire row and column to `0`'s.

**Note:** You must do it **in-place**.

LeetCode Link

## Examples

### Example 1

**Input:** `matrix = [[1,1,1],[1,0,1],[1,1,1]]`  
**Output:** `[[1,0,1],[0,0,0],[1,0,1]]`

### Example 2

**Input:** `matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]`  
**Output:** `[[0,0,0,0],[0,4,5,0],[0,3,1,0]]`

## Constraints

- `m == matrix.length`
- `n == matrix[0].length`
- `1 <= m, n <= 200`
- `-2^31 <= matrix[i][j] <= 2^31 - 1`

## Approaches

### Approach 1: Brute Force

1. Traverse the matrix. When a `0` is found, mark all non-zero elements in the corresponding row and column with a temporary negative value (e.g., `-1`).
2. Traverse the matrix again, and whenever you find the temporary value (`-1`), convert it to `0`.
*Note: This specific brute force implementation assumes the matrix strictly contains positive values. If it contains negative numbers natively, a different marker or secondary matrix must be used.*

**Complexity:**
- **Time Complexity:** `O((N*M) * (N + M)) + O(N*M)` - For every zero, we traverse its row and column.
- **Space Complexity:** `O(1)` - Modifying the array in-place.

### Approach 2: Better (Using Extra Arrays)

Instead of traversing rows and columns repeatedly, we can use two separate arrays to keep track of the rows and columns that need to be zeroed out.

1. Create two arrays: `row_zero_index` of size `m` and `col_zero_index` of size `n`.
2. Traverse the matrix. If `matrix[i][j] == 0`, mark `row_zero_index[i] = 1` and `col_zero_index[j] = 1`.
3. Traverse the matrix again. If `row_zero_index[i] == 1` or `col_zero_index[j] == 1`, set `matrix[i][j] = 0`.

**Complexity:**
- **Time Complexity:** `O(2 * M * N)` - We iterate through the matrix twice.
- **Space Complexity:** `O(M + N)` - Due to the two extra tracker arrays.

### Approach 3: Optimal (In-place Tracking)

We can optimize the space complexity by using the **first row** and **first column** of the matrix itself to keep track of the zeroes instead of creating two new arrays.

1. The first row tracks columns to be zeroed, and the first column tracks rows to be zeroed.
2. Since the first cell `matrix[0][0]` overlaps for both the first row and first column, use an extra variable (`row0`) to track the state of the first column independently.
3. Iterate through the matrix to mark the zeroes in the first row and first column.
4. Iterate through the matrix from `(1, 1)` to `(m-1, n-1)` and use the marks to set cells to zero.
5. Finally, use `matrix[0][0]` and the extra variable to set the first row and first column to zero if needed.

**Complexity:**
- **Time Complexity:** `O(2 * M * N)` - We iterate through the matrix essentially twice.
- **Space Complexity:** `O(1)` - Operations are strictly performed in-place using existing elements.

## Solution (Java)

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        // Approach 3: Optimal
        // Time Complexity: O(2*(m*n))
        // Space Complexity: O(1)
        
        int m = matrix.length; // m --> rows
        int n = matrix[0].length;  // n --> columns
        int row0 = 1; // Used to track if the first column needs to be zeroed

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        row0 = 0;
                    }
                    matrix[i][0] = 0;             
                }
            }
        }

        // Iterate starting from (1,1) to avoid modifying the reference rows/cols early
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] != 0){
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Finally mark the 1st col & then 1st row:
        if(matrix[0][0] == 0){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(row0 == 0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
```
