/*
Approach 1 --- Brute Force, T.C -- O(N*N),S.C -- O(1) 
Yes — you are creating a new 256-length array for each i. That increases allocation frequency, not the asymptotic peak memory usage. 

class Solution {
    public int lengthOfLongestSubstring(String s) {
     
     int n = s.length();
     int max_len = 0;
     for(int i=0;i<n;i++){
        int[] hash = new int[256];
        for(int j=i;j<n;j++){
            if(hash[s.charAt(j)] == 1){
                break;
            }
            max_len = Math.max(j-i+1,max_len);
            hash[s.charAt(j)] = 1;
        }
     }
     return max_len;  
    }
}
*/

/* approach 2 --- using hashmap
T.C -- O(N)
S.C -- O(N)
 we can use array of size 256 to make S.C -- O(1)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map each character to its last seen index
        HashMap<Character, Integer> hm = new HashMap<>();

        int max_len = 0; // Tracks the maximum length found so far
        int l = 0;       // Left pointer of the sliding window

        // Expand the window with 'r' (right pointer)
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            // If the current character was seen before and its last seen index
            // lies within the current window [l..r], move 'l' just after that index
            if (hm.containsKey(ch)) {
                // Important: take max to ensure 'l' never moves backwards
                l = Math.max(l, hm.get(ch) + 1);
            }

            // Update the best window size so far
            max_len = Math.max(max_len, r - l + 1);

            // Record/update the last seen index of current character
            hm.put(ch, r);
        }

        return max_len;
    }
}