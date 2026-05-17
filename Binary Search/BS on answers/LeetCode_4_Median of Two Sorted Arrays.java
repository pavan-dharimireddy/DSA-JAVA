/* my solution - 1

t.c = o(m+n)
s.c = o(m+n)


import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=0,n2=0,i=0;
        int[]  arr = new int[nums1.length + nums2.length];
        double ans = 0.0;
        while(n1<nums1.length && n2<nums2.length){
            if(nums1[n1]<=nums2[n2]){
                arr[i++] = nums1[n1++];
                
            }
            else{
                arr[i++] = nums2[n2++];
            }
        }
        while(n1<nums1.length){
            arr[i++] = nums1[n1++];
        }

        while(n2<nums2.length){
            arr[i++] = nums2[n2++];
        }

        if(arr.length%2==0){
            ans = (arr[(int)arr.length/2] + arr[(int)(arr.length/2)-1])/2.0;
        }
        else{
            ans = arr[(int)(arr.length/2)]/1.0;
        }
        
    
    return ans;
    }
}
*/

/*
my solution - 2  -- not working
t.c = o(m+n)
s.c = o(1)



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int total = m + n;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for (int k = 0; k <= total / 2; k++) {
            prev = curr;

            if (i < m && (j >= n || nums1[i] <= nums2[j])) { // --> short circuting helps here 
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
            // IF nums1 has elements left AND
            // (nums2 is finished OR nums1[i] is smaller)
            // THEN take nums1[i]
            // ELSE take nums2[j]
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}

*/

/*

solution -3 
t.c = O(log (m+n))
s.c = O(1)
https://youtu.be/NTop3VTjmxk


A common question, why take first smaller array, because the complexity of bs is search space, so the smaller the search space, smaller the complexity. You can take the larger array, but the search space will be bigger.

*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Step 1: Always binary search on smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;

        while (low <= high) {

            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition
            if (l1 <= r2 && l2 <= r1) {

                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }

            // Move left
            else if (l1 > r2) {
                high = cut1 - 1;
            }

            // Move right
            else {
                low = cut1 + 1;
            }
        }

        return 0.0; // never reaches here
    }
}