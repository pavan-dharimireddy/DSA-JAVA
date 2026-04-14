/*
Approach 1 ---> Brute Force ,
T.C 
Final Time Complexity:
👉 O(n³)
Inside operations:
Sum check → O(1)
Sorting 3 elements → O(1) (as per your condition)
Inserting into HashSet → O(1) average

Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> s = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(temp);
                        s.add(temp);
                    }
                }
            }
        }
    return new ArrayList<>(s);
    }
}
*/

/*
Approach 2 ---> using hashing ,
T.C 
Final Time Complexity:
👉 O(N*N)

Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> s = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third = -(nums[i]+nums[j]);
                    if(hashset.contains(third)){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],third);
                        Collections.sort(temp);
                        s.add(temp);
                    }
            hashset.add(nums[j]);
            }
        }
    return new ArrayList<>(s);
    }
}
*/
/*
Optimal approach:: 

Time Complexity: O(NlogN)+O(N2), as The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 

Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }

                }
            }
        }
    return ans;
    }
}