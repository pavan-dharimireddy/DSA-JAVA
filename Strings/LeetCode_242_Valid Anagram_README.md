# 242. Valid Anagram

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Examples

### Example 1
**Input:** `s = "anagram", t = "nagaram"`  
**Output:** `true`  

### Example 2
**Input:** `s = "rat", t = "car"`  
**Output:** `false`  

## Constraints

- `1 <= s.length, t.length <= 5 * 10^4`
- `s` and `t` consist of lowercase English letters.

## Approaches

### Approach 1: Frequency Array (Optimal)
Since the characters are bounded by standard character sets (e.g., ASCII), we can use a fixed-size integer array of length 256 to count character frequencies. 
1. First, check if the lengths of the two strings are equal. If not, they cannot be anagrams.
2. Iterate through both strings simultaneously. For every character in `s`, increment its corresponding index in the frequency array. For every character in `t`, decrement its corresponding index.
3. Finally, iterate through the frequency array. If all elements are `0`, the strings are anagrams. If any element is non-zero, return `false`.

- **Time Complexity:** `O(N)` where `N` is the length of the strings. We traverse the strings once and then do a constant-time traversal (256 operations) over the array.
- **Space Complexity:** `O(1)` because the size of the array (256) is constant and does not scale with the input size.

### Approach 2: HashMap Frequency Counting
Alternatively, a `HashMap` can be used to track the occurrences of each character in `s`. Then, we iterate through `t`, decrementing the counts in the map. If any character in `t` is missing from the map or its count drops below zero, they are not anagrams.

- **Time Complexity:** `O(N)` where `N` is the length of the strings. Insertion and lookup in a HashMap take `O(1)` time on average.
- **Space Complexity:** `O(1)` as a map storing lowercase English letters will hold at most 26 key-value pairs, which requires constant extra space (though it has slightly higher overhead than a primitive array).

## Solution (Java)

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if(s.length() != t.length()){
            return false;
        }
        
        // Frequency array for ASCII characters
        int[] arr = new int[256];
        
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)]++;
            arr[t.charAt(i)]--;
        }
        
        // Check if there's any non-zero frequency
        for(int x : arr){
            if(x != 0){
                return false;
            }
        }
        
        return true;
    }
}

/*
// Approach 2: Using HashMap
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            if(!hm.containsKey(t.charAt(i))){
                return false;
            }
            hm.put(t.charAt(i),hm.get(t.charAt(i))-1);
        }
        for(char key : hm.keySet()){
            if(hm.get(key)!=0){
                return false;
            }
        }
        return true;
    }
}
*/
```
