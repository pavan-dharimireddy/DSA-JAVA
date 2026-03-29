class Solution {
    public int subarraySum(int[] nums, int k) {
        
        /*
        https://youtu.be/frf7qxiN2qU?si=WoPog72dkga6Gnoo

        // subarray is contigious, complete array is also a subarray
        // approach 1, brute force, time complexity -- O(N*N),extra space complexity -- O(1)
        // int max_len = Integer.MIN_VALUE;
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            
            for(int j=i;j<n;j++){
                sum += nums[j];
                if(sum==k){
                    // max_len = Math.max(max_len,j-i+1);  ---> if we only considered about max_length of the subarray
                    count++;
                }
            }
        }
        return count;

        */

        /*
//  if we only considered about max_length of the subarray 

        int max_len = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            sum += nums[i];
            // special case [1,-1,0]
            if(sum==k){
                max_len = Math.max(max_len,i+1);
               
                
            }
            if(m.containsKey(sum-k)){
                max_len = Math.max(max_len,i-m.get(sum-k));
                
               
            }
            if(!m.containsKey(sum)){
                m.put(sum,i);
            }
              
        }
        return count;

        */

       

    //https://youtu.be/xvNwoz-ufXA?si=MSHjTeL_GzGEbs1_ 
    // The time complexity of operations in a HashMap is O(log(N))
    // time complexity --> O(N*Log(N)) , extra space complexity -- O(N)

        int n = nums.length;
        int count = 0;
        int sum = 0;
         
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(sum,1);
        for(int i=0;i<n;i++){
            

             // special cases [1,-1,0] , [0,0,0,0,0,0,0,0,0,0]
            sum += nums[i];
            count = count + m.getOrDefault(sum-k,0);
            m.put(sum,m.getOrDefault(sum,0)+1);
         
              
        }
        return count;
    }
}