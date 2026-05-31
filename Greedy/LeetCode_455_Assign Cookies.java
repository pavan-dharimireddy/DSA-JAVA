/*
Approach -- Greedy
Time ComplexityO(M log M + N log N + M + N)
Space ComplexityO(log M + log N)
*/class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        int l=0,r=0;
        while(l<m && r<n){
            if(g[l] <= s[r]){
                l = l+1;
            }
            r = r+1;
        }
    return l;
    }
}