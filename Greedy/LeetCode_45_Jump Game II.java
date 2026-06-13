// T.C --- O(N) , S.C --- O(1)
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, l=0,r=0;
        while(r < nums.length-1){
            int maxIndex = 0;
            for(int i=l;i<=r;i++){
                maxIndex = Math.max(i+nums[i],maxIndex);
            }
            l = r+1;
            r = maxIndex;
            jumps++;
        }
    return jumps;
    }
}