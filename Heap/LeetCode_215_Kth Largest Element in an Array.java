
/*
Approach 1 : Sorting
Complexity

Time: O(nlog⁡n)
Space: O(1) (in-place sort)


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
}
*/

/* Approach 2 -- Max Heap
Time Complexity: O(nlog⁡n)​

Space Complexity: O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            pq.add(i);
        }
        for(int i=1;i<k;i++){
            pq.poll();
        }
    return pq.poll();
    }
}
*/


/*
Approach 3 --- Min heap with K elements

O(klogk) + O((N-k)logk) ----> O(NlogK)
Time Complexity: O(N * log K), where N is the size of the given input array. Traversing the array takes O(N) time, and for each element, in the worst case, we perform heap operations which take O(log K) time. Note that K can be equal to N in the worst case, making the worst-case time complexity as O(N * log N).

Space Complexity: O(K), as a Min-heap data structure of size K is used to store the K largest elements.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        // Add the first K elements in the Min-heap
        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        
        // Process the rest of the elements 
        for(int i = k; i < nums.length; i++) {
            // Check if a new larger element is found
            if(nums[i] > pq.peek()) {
                
                pq.poll(); // remove the smallest from the min-heap
                
                // Add the current element to the min-heap
                pq.add(nums[i]);
            }
        }
        
        return pq.peek(); // Return the kth largest element 
    }

}
*/

/*
Approach 4 --> QuickSelect 

Time Complexity: O(N), where N is the size of the given array.
In the average case (when the pivot is chosen randomly):
Assuming the array gets divided into two equal parts, with every partitioning step, the search range is reduced by half. Thus, the time complexity is O(N + N/2 + N/4 + ... + 1) = O(N).

In the worst-case scenario (when the element at the left or right index is chosen as the pivot):
In such cases, the array is divided into two unequal halves, and the search range is reduced by one element with every partitioning step. Thus, the time complexity is O(N + N-1 + N-2 + ... + 1) = O(N2). However, the probability of this worst-case scenario is negligible.

Space Complexity: O(1), as we are modifying the input array in place and using only a constant amount of extra space.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
         // Return -1, if the Kth largest element does not exist
        if (k > nums.length) return -1;

        // Pointers to mark the part of working array
        int left = 0, right = nums.length - 1;

        // Until the Kth largest element is found
        while (true) {
            // Get the pivot index
            int pivotIndex = randomIndex(left, right);

            // Update the pivotIndex
            pivotIndex = partitionAndReturnIndex(nums, pivotIndex, left, right);

            // If Kth largest element is found, return
            if (pivotIndex == k - 1) return nums[pivotIndex];

            // Else adjust the end pointers in array
            else if (pivotIndex > k - 1) right = pivotIndex - 1;
            else left = pivotIndex + 1;
        }
    }
    
    private Random rand = new Random();

    // Function to get a random index
    private int randomIndex(int left, int right) {
        // Length of the array
        int len = right - left + 1;
        
        // Return a random index from the array
        return rand.nextInt(len) + left;
    }



    // Function to perform the partition and return the updated index of pivot
    private int partitionAndReturnIndex(int[] nums, int pivotIndex, int left, int right) {
        int pivot = nums[pivotIndex]; // Get the pivot element
        
        // Swap the pivot with the left element
        int temp = nums[left];
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = temp;
        
        int ind = left + 1; // Index to mark the start of right portion
        
        // Traverse on the array
        for (int i = left + 1; i <= right; i++) {
            
            // If the current element is greater than the pivot
            if (nums[i] > pivot) {
                // Place the current element in the left portion
                temp = nums[ind];
                nums[ind] = nums[i];
                nums[i] = temp;
                
                // Move the right portion index
                ind++;
            }
        }
        
        // Place the pivot at the correct index
        temp = nums[left];
        nums[left] = nums[ind - 1];
        nums[ind - 1] = temp;
        
        return ind - 1; // Return the index of pivot now
    }
}
    