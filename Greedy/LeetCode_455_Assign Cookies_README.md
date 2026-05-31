# 455. Assign Cookies

## Problem Statement

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child `i` has a greed factor `g[i]`, which is the minimum size of a cookie that the child will be content with; and each cookie `j` has a size `s[j]`. If `s[j] >= g[i]`, we can assign the cookie `j` to the child `i`, and the child `i` will be content. Your goal is to maximize the number of your content children and output the maximum number.

## Approach: Greedy and Two Pointers

To maximize the number of content children, we should always try to satisfy the least greedy children first, using the smallest possible cookies that meet their requirements.

1.  **Sort:** Sort both the children's greed factors array `g` and the cookie sizes array `s` in ascending order.
2.  **Two Pointers:** Initialize two pointers: `l` pointing to the start of array `g` and `r` pointing to the start of array `s`.
3.  **Iterate:** Loop while both pointers are within the bounds of their respective arrays:
    *   If the current cookie size `s[r]` is greater than or equal to the current child's greed `g[l]`, the child is content. We increment the child pointer `l` to check the next child.
    *   Regardless of whether the cookie was used to satisfy the child or was too small, we move to the next cookie by incrementing the cookie pointer `r`.
4.  **Result:** The pointer `l` will ultimately indicate the total number of children that received a cookie they are content with.

## Complexity

-   **Time Complexity:** `O(M log M + N log N)` where `M` is the length of array `g` and `N` is the length of array `s`. This is due to the time required to sort both arrays. The subsequent two-pointer traversal takes `O(M + N)` time, making sorting the dominant operation.
-   **Space Complexity:** `O(log M + log N)` auxiliary space, which is typically required by the sorting algorithms implemented in Java under the hood (like Dual-Pivot Quicksort for primitives).

## Solution (Java)

```java
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both the greed factors and the cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        int m = g.length;
        int n = s.length;
        
        // l points to children (greed factor), r points to cookies
        int l = 0, r = 0;
        
        while (l < m && r < n) {
            // If the current cookie can satisfy the current child
            if (g[l] <= s[r]) {
                l = l + 1; // Move to the next child
            }
            // Always move to the next cookie to try
            r = r + 1;
        }
        
        // l represents the total number of satisfied children
        return l;
    }
}
```
