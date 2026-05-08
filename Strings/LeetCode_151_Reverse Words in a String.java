/* approach 1 ---> using inbuilt functions trim and split
⏱ Time Complexity: O(n)
💾 Space Complexity: O(n)
Because split() creates a new array


class Solution {
    public String reverseWords(String s) {
        s = s.trim();    //remove leading/trailing spaces
        String[] words = s.split("\\s+");    //split by one or more spaces
        StringBuilder sb = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);    //append word
            if(i != 0) sb.append(" ");    //add space except after last word
        }
        return sb.toString();
    }
}
*/

/* approach 2 ---> two pointers 
⏱ Time Complexity: O(n)
💾 Space Complexity: O(n)
Only stores the reversed result, no array split.
*/
class Solution {
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while(i >= 0){

            // skip spaces at the end or between words
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            if(i < 0) break;    // no more words

            int end = i;    // end of word

            // move to the start of the word
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            

            if (sb.length() > 0) { sb.append(" "); }    //append a space before the next word if result is not empty
            sb.append(s.substring(i + 1, end + 1));    //append the current word [i+1..end]

        }

        return sb.toString();
    }
}