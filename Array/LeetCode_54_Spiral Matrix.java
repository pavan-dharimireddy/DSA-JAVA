
/* Example 

 {{ 1, 2, 3, 4 },
  { 5, 6, 7, 8 },
  { 9, 10, 11, 12 },
  { 13, 14, 15, 16 } }

  */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        // optimal approach , time complexity --- O(n*m) , Space complexity ---- O(n*m)
        int no_of_rows = matrix.length;
        int no_of_cols = matrix[0].length;
        int top = 0;
        int bottom = no_of_rows-1;
        int left = 0;
        int right = no_of_cols-1;
        List<Integer> l = new ArrayList<>();

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                l.add(matrix[top][i]);
                }
            top++;

            for(int j=top;j<=bottom;j++){
                l.add(matrix[j][right]);
            }
            right--;
            if(top<=bottom){
            for(int k=right;k>=left;k--){
                l.add(matrix[bottom][k]);
            }
            bottom--;
            }
            
            if(left<=right){
            for(int m=bottom;m>=top;m--){
                l.add(matrix[m][left]);
            }
            left++;
            }
        }
        return l;
    }
}