class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int max_count = 0;
        int count = 0;
        for (int x : nums) {
            if (x == 1) {
                count++;
            } else {
                max_count = Math.max(max_count, count);
                count = 0;
            }
        }
        max_count = Math.max(max_count, count);

        return max_count;

    }
}