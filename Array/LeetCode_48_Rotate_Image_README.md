# 48. Rotate Image

## Problem Statement

You are given an `n x n` 2D `matrix` representing an image, rotate the image by **90** degrees (clockwise).

You have to rotate the image **in-place**, which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

LeetCode Link

## Examples

### Example 1

**Input:** `matrix = [[1,2,3],[4,5,6],[7,8,9]]`  
**Output:** `[[7,4,1],[8,5,2],[9,6,3]]`

### Example 2

**Input:** `matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]`  
**Output:** `[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]`

## Constraints

- `n == matrix.length == matrix[i].length`
- `1 <= n <= 20`
- `-1000 <= matrix[i][j] <= 1000`

## Approaches

### Approach 1: Brute Force (Using Extra Space)

We can create a new `n x n` matrix. We then iterate through the original matrix and place each element in its rotated position in the new matrix. The element at `matrix[i][j]` moves to `new_matrix[j][n - 1 - i]`.

- **Time Complexity:** `O(N^2)` — We traverse the entire `N x N` matrix once.
- **Space Complexity:** `O(N^2)` — We use an entirely new matrix of the same size to store the rotated image.

### Approach 2: Optimal (In-place using Transpose & Reverse)

Instead of allocating a new matrix, we can achieve the rotation in-place by breaking down a 90-degree clockwise rotation into two simpler matrix operations:

1. **Transpose the Matrix:** Convert rows to columns by swapping `matrix[i][j]` with `matrix[j][i]` for all elements where `i < j`.
2. **Reverse Every Row:** After the transpose, reversing the elements of each row individually yields the final 90-degree rotated image.

- **Time Complexity:** `O(N^2)` — Transposing the matrix takes `O(N^2 / 2)` and reversing the rows takes `O(N * N / 2)`. Overall time complexity is strictly bounded by `O(N^2)`.
- **Space Complexity:** `O(1)` — The modification is done entirely in-place.

## Solution (Java)

```java
class Solution {
    public void rotate(int[][] matrix) {

        /*
        // Approach 1: Brute force
        // Time complexity: O(N*N), Space complexity: O(N*N)
        int n = matrix.length;
        int[][] new_matrix = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                new_matrix[j][n-1-i] = matrix[i][j];
            }
        }
        // Note: You would then need to copy new_matrix back into matrix
        // to satisfy the in-place return requirement.
        */

        // Approach 2: Optimal
        // Time complexity: O(N/2 * N/2) + O(N * N/2) -> O(N^2)
        // Space complexity: O(1)
        int n = matrix.length;

        // Step 1: Transpose
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                swap(matrix, i, j);
            }
        }

        // Step 2: Reverse every row
        for(int i=0; i<n; i++){
            reverse(matrix[i], 0, n-1);
        }
    }

    // Helper method to swap elements for Transpose
    public void swap(int[][] matrix, int a, int b){
        int temp = matrix[a][b];
        matrix[a][b] = matrix[b][a];
        matrix[b][a] = temp;
    }

    // Helper method to reverse a 1D array
    public void reverse(int[] arr, int start, int end){
        int temp = 0;
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
```
