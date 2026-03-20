class Solution {
    public int[] rearrangeArray(int[] nums) {

/*
        // approach ,, using LinkedHashMap,, time complexity --- O(2N*operations of LinkedHashMap) , extra Space complexity --- O(N)
        // LinkedHashMap  Average Case: O(1) (due to hashing).
Worst Case: O(n) (if hash collisions occur, leading to a linked list or tree traversal).

        int n = nums.length;
        LinkedHashMap<Integer,Integer> lhmp = new LinkedHashMap<>();
        LinkedHashMap<Integer,Integer> lhmn = new LinkedHashMap<>();
        int evencounter = 0,oddcounter = 1;

        for(int i=0;i<n;i++){
            if(nums[i]<0){
                lhmn.put(oddcounter,nums[i]);
                oddcounter += 2;
            }
            else{  // we won't have 0 in the given array
                lhmp.put(evencounter,nums[i]);
                evencounter += 2;
            }
        }

        for(int i=0;i<n;i=i+2){
            nums[i] = lhmp.get(i);
        }
        for(int i=1;i<n;i=i+2){
            nums[i] = lhmn.get(i);
        }
    return nums;

*/

/*
    // approach 2 modifying approach 1 using arraylist,, time complexity --- O(N + N/2), extra Space complexity --- O(n)
    int n = nums.length;
    ArrayList<Integer> alp = new ArrayList<>();
    ArrayList<Integer> aln = new ArrayList<>();

    for(int i=0;i<n;i++){
        if(nums[i]<0){
            aln.add(nums[i]);
        }
        else{
            alp.add(nums[i]);
        }
    }

    for(int i=0;i<alp.size();i++){
            nums[2*i] = alp.get(i);
    }
    for(int i=0;i<aln.size();i++){
            nums[2*i+1] = aln.get(i);
    }
 
    return nums;
*/


    // approach 3(optimal),instead of using two arrayList we are using one and loop runs only one time , time complexity -- O(N), space complexity -- O(N)

    int n = nums.length;
    int[] result = new int[n];
    int even_position = 0;
    int odd_position = 1;
    for(int i=0;i<n;i++){
        if(nums[i]>0){
            result[even_position] = nums[i];
            even_position += 2;
        }
        else{
            result[odd_position] = nums[i];
            odd_position += 2;
        }
    }
    return result;

    }
}

// follow up question, length of +ve elements and -ve elements are not same,, fall back to brute force, optimal won't work
// https://youtu.be/h4aBagy4Uok?si=53jZuqKjco4B_gxx   ---> video solution 