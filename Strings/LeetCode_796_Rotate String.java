/* approach 1, brute force
Time Complexity: O(N^2) since generating N rotations and each comparison takes O(N) time.

Space Complexity: O(N) for the space needed to store each rotated string.

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        else{
        
        for(int i=0;i<s.length();i++){
            String sb = s.substring(i+1,s.length()) + s.substring(0,i+1);
            if(sb.equals(goal)){
                return true;
            }
     }
        }
        return false;
    }
}
*/

/*
Time Complexity: O(N), because checking for a substring in s + s is linear in time.

Space Complexity: O(N) for the space needed to store the concatenated string s + s.
*/
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        String newString=s+s;
        return newString.contains(goal);
    }
}