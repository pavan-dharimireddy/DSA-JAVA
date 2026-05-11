/* T.C ---> O(N*log(N)+M) , S.C ---> O(M)
N ---> Number of strings in the array
M ---> Minimum length of String
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {

        // If there is only one string, that itself is the longest common prefix
        if (strs.length == 1) {
            return strs[0];
        }

        // Sort the array lexicographically , Lexicographically means “in dictionary order.”
        // After sorting, the strings with the smallest and largest prefixes
        // will be placed at the beginning and end.
        Arrays.sort(strs);

        // First string (smallest lexicographically)
        String first = strs[0];
        // Last string (largest lexicographically)
        String last = strs[strs.length - 1];

        int i = 0;

        // Compare characters of the first and last string
        // Only these two need to be compared because sorting ensures
        // that the common prefix among all strings must also be a prefix
        // of the first and last string.
        for (; i < Math.min(first.length(), last.length()); i++) {
            // If characters differ, stop — the prefix ends here
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
        }

        // Return the common prefix substring found so far
        return first.substring(0, i);
    }
}