/* HashMap Approach --- T.C -- O(N),S.C -- O(N)
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> l = new ArrayList<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(entry.getValue() > nums.length/3){
                l.add(entry.getKey());
            }
        }
    return l; 
    }
}
*/



class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int n = nums.length;

        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        // Phase 1: find possible candidates
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && element2 != nums[i]) {
                element1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && element1 != nums[i]) {
                element2 = nums[i];
                count2 = 1;
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // ✅ Phase 2: recount actual frequencies
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == element1) count1++;
            else if (num == element2) count2++;
        }

        int mini = n / 3 + 1;
        if (count1 >= mini) l.add(element1);
        if (count2 >= mini && element1 != element2) l.add(element2);

        return l;
    }

}

/*
Why the Algorithm Needs Two Phases
The Boyer–Moore algorithm has two mandatory phases:
1️⃣ Candidate selection (voting & cancellation)
2️⃣ Candidate validation (recounting actual frequencies)
We identified that:

count1 and count2 after phase 1 are NOT real frequencies
They must be reset and recomputed in a second loop

Without phase 2, the solution fails on multiple inputs.

The Line in Question
Javaif (count2 >= mini && element1 != element2)    l.add(element2);Show more lines
You asked:

If element1 and element2 are already guaranteed to be different, why do we still need element1 != element2?


5️⃣ The Honest Answer
There are two key truths:
✅ Truth #1 (you were right)
In your candidate‑selection logic,
element1 == element2 does not happen.
✅ Truth #2 (why the check still exists)
The condition
Javaelement1 != element2Show more lines
is NOT protecting the voting logic.
It is protecting the final output contract.

It is defensive programming, not a bug fix.

You could remove it in your current code and it would still work —
but keeping it makes the solution robust, clear, and standard‑compliant.


*/