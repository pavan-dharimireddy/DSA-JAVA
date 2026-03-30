# Building a Max-Heap using Heapify

## Description

This Java program demonstrates the **build-heap** algorithm, which converts an arbitrary array into a **max-heap** data structure in-place. The core of this process is the `heapify` method.

A **max-heap** is a complete binary tree where the value in each internal node is greater than or equal to the values in the children of that node.

## Algorithm Explained

The process involves two main parts:

1.  **`heapify(array, n, i)`:**
    *   This is a recursive procedure to maintain the max-heap property.
    *   It takes a node at index `i` and assumes its left and right subtrees are already valid max-heaps.
    *   It finds the largest among the node `i`, its left child, and its right child.
    *   If the current node `i` is not the largest, it is swapped with the largest child.
    *   The `heapify` procedure is then called recursively on the affected subtree to ensure the heap property is maintained downwards.

2.  **Build-Heap Process:**
    *   A heap can be built from an unsorted array by applying the `heapify` procedure in a bottom-up manner.
    *   We start from the last non-leaf node (at index `n/2 - 1` for a 0-indexed array) and iterate backwards up to the root (index 0).
    *   By calling `heapify` on each of these nodes, we guarantee that the subtree rooted at that node becomes a valid max-heap. When the loop finishes, the entire array represents a max-heap.

## Complexity

-   **Time Complexity:** **O(N)**. Although the `heapify` operation on a single node is O(log N), the build-heap process calls it on `N/2` nodes. A tighter analysis shows that the total time complexity is linear, i.e., O(N).
-   **Space Complexity:** **O(log N)**. This is due to the recursion depth of the `heapify` function, which in the worst case is the height of the tree.

## Code Analysis and Correction

The original `Heapify_of_Array.java` file contains a few logical errors related to array indexing and conditional logic. A corrected version is provided below for clarity and correctness.

### Issues in the Original Code:
1.  **Indexing Mismatch:** The code uses 1-based indexing logic (`left = 2*i`, `right = 2*i+1`) on a 0-indexed Java array, which is incorrect. The `main` loop also starts from `n/2` and goes to `1`, which is suited for 1-based indexing.
2.  **Faulty Conditional Logic:** The check for the `right` child was nested inside the check for the `left` child, meaning the right child would never be considered if the left child was smaller than the parent.

### Corrected Code (`Heapify_of_Array.java`)

```java
import java.util.Arrays;

class Heapify_of_Array {

    public static void main(String[] args) {
        int[] arr = new int[]{20, 10, 30, 5, 50, 40};
        int n = arr.length;
        System.out.println("Before Heapify ---- > " + Arrays.toString(arr));

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        System.out.println("After Heapify ---- > " + Arrays.toString(arr));
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
```

## How to Use

1.  Save the corrected code as `Heapify_of_Array.java`.
2.  Compile and run the Java file from your terminal:
    ```bash
    javac Heapify_of_Array.java
    java Heapify_of_Array
    ```

## Example Output

Running the corrected program will produce the following output, showing the array's transformation into a valid max-heap:

```
Before Heapify ---- > [20, 10, 30, 5, 50, 40]
After Heapify ---- > [50, 20, 40, 5, 10, 30]
```
