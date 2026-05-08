# 151. Reverse Words in a String

## Problem Statement

Given an input string `s`, reverse the order of the **words**.

A **word** is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

**Note:** that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

## Examples

### Example 1
**Input:** `s = "the sky is blue"`  
**Output:** `"blue is sky the"`

### Example 2
**Input:** `s = "  hello world  "`  
**Output:** `"world hello"`  
**Explanation:** Your reversed string should not contain leading or trailing spaces.

### Example 3
**Input:** `s = "a good   example"`  
**Output:** `"example good a"`  
**Explanation:** You need to reduce multiple spaces between two words to a single space in the reversed string.

## Constraints

- `1 <= s.length <= 10^4`
- `s` contains English letters (upper-case and lower-case), digits, and spaces `' '`.
- There is **at least one** word in `s`.

## Approaches

### Approach 1: Using Built-in Functions (`trim` and `split`)
This approach uses Java's built-in `String` methods. We first `trim()` the string to remove any leading or trailing spaces. Then, we use `split("\\s+")` to split the string into an array of words, treating multiple consecutive spaces as a single delimiter. Finally, we iterate through the array backwards and append each word to a `StringBuilder`.
- **Time Complexity:** `O(N)` — Where `N` is the length of the string. Both `trim()` and `split()` take linear time.
- **Space Complexity:** `O(N)` — The `split()` method creates a new array of strings, and we use a `StringBuilder` to store the result.

### Approach 2: Two Pointers (Optimal for no splitting)
Instead of splitting the string into an array, we can iterate from the end of the string to the beginning using a pointer. We identify the end of a word, move the pointer to find the start of the word, and then extract the substring. We append each found word to a `StringBuilder`, manually ensuring that only a single space separates the words.
- **Time Complexity:** `O(N)` — We traverse the string backwards exactly once.
- **Space Complexity:** `O(N)` — Space is used by the `StringBuilder` to build the final reversed string. It avoids creating intermediate string arrays.

## Solution (Java)

```java
/*
// Approach 1: Using Built-in Functions
class Solution {
    public String reverseWords(String s) {
        s = s.trim();    // remove leading/trailing spaces
        String[] words = s.split("\\s+");    // split by one or more spaces
        StringBuilder sb = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);    // append word
            if(i != 0) sb.append(" ");    // add space except after last word
        }
        return sb.toString();
    }
}
*/

// Approach 2: Two Pointers
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // skip spaces at the end or between words
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;    // no more words
            
            int end = i;    // end of word
            // move to the start of the word
            while (i >= 0 && s.charAt(i) != ' ') i--;
            
            if (sb.length() > 0) sb.append(" ");    // append a space before the next word if result is not empty
            sb.append(s.substring(i + 1, end + 1));    // append the current word [i+1..end]
        }
        return sb.toString();
    }
}
```
