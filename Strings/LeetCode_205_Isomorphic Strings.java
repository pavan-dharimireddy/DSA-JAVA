/* approach 1 using hashmap
✅ Time Complexity (TC)
O(n)
Where n = length of the strings s and t.

Space Complexity (SC)
O(1) → constant extra space
Even though you're using two HashMaps:
They can store at most 256 entries (all ASCII characters), because:

Only characters (0–255) can be keys
No character maps twice
So max entries is bounded by a small fixed constant

This makes the space constant, i.e., O(1).

class Solution {
    public boolean isIsomorphic(String s, String t) {

        // If lengths differ, they can never be isomorphic
        if (s.length() != t.length()) return false;

        // Map for s -> t
        HashMap<Character, Character> mapST = new HashMap<>();
        // Map for t -> s (to prevent conflicts)
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i); // char from s
            char ct = t.charAt(i); // char from t

            // If s already mapped but mapping is different => not isomorphic
            if (mapST.containsKey(cs)) {
                if (mapST.get(cs) != ct) return false;
            } 
            // If t already mapped but mapping is different => not isomorphic
            else if (mapTS.containsKey(ct)) {
                if (mapTS.get(ct) != cs) return false;
            }

            // Add both mappings
            mapST.put(cs, ct);
            mapTS.put(ct, cs);
        }

        return true; // Passed all checks -> Strings are isomorphic
    }
}
*/

/*
We use two arrays to store the last index where each character appeared. If the last seen indices don’t match, the mapping is inconsistent
Complexity

Time: O(n) — single pass through the strings.
Space: O(1) — arrays of fixed size (256).
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Assuming ASCII. Use 256 for extended ASCII.
        int[] sLast = new int[256];
        int[] tLast = new int[256];

        // // Initialize with -1 (meaning "not seen yet")
        for (int i = 0; i < 256; i++) {
            sLast[i] = -1;
            tLast[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int cs = s.charAt(i);
            int ct = t.charAt(i);

            // If last seen positions differ, mapping is inconsistent
            if (sLast[cs] != tLast[ct]) {
                return false;
            }

            // Mark both as last seen at index i
            sLast[cs] = i;
            tLast[ct] = i;
        }

        return true;
    }
}