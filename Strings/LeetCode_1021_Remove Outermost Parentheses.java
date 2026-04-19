// approach 1 :: using Stack, T.C ---> O(N) , S.C ---> O(N)

/*
class Solution {
    public String removeOuterParentheses(String s) {
        int len = s.length();
        String ans = "";
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<len;i++){
            if(s.charAt(i)== '(' ){
                if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else{
                stack.push(s.charAt(i));
                ans += s.charAt(i);
            }
            }
            else{
                stack.pop();
                if(!stack.isEmpty()){
                    ans += s.charAt(i);
                }

            }
            
        }
        return ans;
    }
}
*/

// approach 2 :: using counter, T.C ---> O(N) , S.C ---> O(1)
/*
A String in Java is not an array or a collection; it’s an object that internally stores characters in a char[]. The for-each loop works on arrays or classes implementing Iterable. Since String doesn’t implement Iterable<Character>, you can’t do this directly:
*/

class Solution {
    public String removeOuterParentheses(String s) {
        int len = s.length();
        String ans = "";
        int counter = 0;
        for(char i : s.toCharArray()){
            if(i == '('){
                if(counter !=0){
                    ans += i;
                    counter++;
                }
                else{
                    counter++;
                }
                
            }
            else{
                counter--;
                if(counter !=0){
                    ans += i;
                }
            }
        }
        
        return ans;
    }
}