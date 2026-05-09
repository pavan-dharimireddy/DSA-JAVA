/* approach 1
✅ Time Complexity (T.C)
O(n)

In the worst case, the loop runs through the entire string once from right to left.
substring(0, n+1) is O(n) because Java copies the characters to a new string.

So total → O(n).

✅ Space Complexity (S.C)
O(n)

The returned substring creates a new string of size up to n.
No extra data structures are used.

Therefore → O(n) due to the output string itself.

*/

class Solution {
    public String largestOddNumber(String num) {
        int n = num.length()-1;    //start from the last index
        while (n >= 0) {    //iterate backwards through the string
            if (num.charAt(n) % 2 == 1) {    //check if the last char is odd (char%int = int)
                break;    //found an odd-ending; stop
            }
            n--;    //move left if current digit is even
        }
        return num.substring(0, n + 1);    //return prefix up to the last odd digit (empty string if none)
        // num.substring(0, 0) ---> empty string
    }
}
/*  if (((c - '0') & 1) == 1) {    //check if digit is odd */


/* approach 2 
✅ Time Complexity (T.C)
O(d)
where d is the number of digits in the number (num.length()).

✅ Space Complexity (S.C)
O(1) extra space
Because:

You use only a few variables (n, loop variables).
The output String.valueOf(n) does not count as extra space (output space is not counted in space complexity).

class Solution {
    public String largestOddNumber(String num) {
        int n = Integer.parseInt(num);    //parse the numeric string into an int (may overflow for very large inputs)
        while (n > 0) {    //iterate while there is a positive number left
            if (n % 2 == 1) {    //check if current number is odd
                break;    //if odd, stop the loop
            }
            n = n / 10;    //drop the last digit (equivalent to removing one char from the end)
        }
        if (n == 0) {    //if no odd-ending prefix exists
            return "";    //return empty string as per requirement
        }
        return String.valueOf(n);    //convert the remaining integer back to string
    }
}
*/