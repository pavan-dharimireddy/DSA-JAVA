/*
T.C --- O(N*N*numberofrows), S.C -- O(1)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            List<Integer> temp = new ArrayList<>();

            for(int j=1;j<=i;j++){
                temp.add(fact(i-1)/(fact(j-1)*fact(i-j)));
            }
            l.add(temp);
        }
        return l;
    }

    public int fact(int n){
        if(n<=1){
            return 1;
        }
        return n*fact(n-1);
    }
}
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  l = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            l.add(innerList(i));
        }
        return l;
    }

    public List<Integer> innerList(int n){
        List<Integer> temp = new ArrayList<>();
        int res=1;
        temp.add(res);
        for(int i=1;i<n;i++){
            res = res*(n-i);
            res = res/i;
            temp.add(res);
        }
    return temp;
    }
}