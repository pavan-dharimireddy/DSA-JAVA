
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[256];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]++;
            arr[t.charAt(i)]--;
        }
        
        for(int x: arr){
            if(x!=0){
                return false;
            }
        }
        
        return true;
    }
}

/*
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