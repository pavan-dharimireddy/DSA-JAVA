/* T.C --- O(N)
   S.C --- O(1)
*/

class Solution {
    public boolean checkValidString(String s) {

        // Variable to track minimum possible open brackets at current index
        int min = 0;

        // Variable to track maximum possible open brackets at current index
        int max = 0;

        // Traverse through each character in the string
        for (char c : s.toCharArray()) {

            // If character is '(', it increases both min and max
            if (c == '(') {
                min++;
                max++;
            }
            // If character is ')', it decreases both min and max
            else if (c == ')') {
                min--;
                max--;
            }
            // If character is '*', it can be '(', ')' or ''
            else {
                // if '*' is treated as ')'
                min--;

                // if '*' is treated as '('
                max++;
            }

            // If max becomes negative → too many closing brackets → invalid
            if (max < 0) return false;

            // min can't go below 0 (we can't have negative open brackets)
            if (min < 0) min = 0;
        }

        // If min is 0 at the end → valid string
        return min == 0;
    }
}