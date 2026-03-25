class Solution {
    public void rotate(int[][] matrix) {

/*
     // approach 1, brute force,, time complexity --- O(n*n), space complexity --- O(n*n)
     int n = matrix.length;
     int[][] new_matrix = new int[n][n];

     for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            new_matrix[j][n-1-i] = matrix[i][j];
        }
     }
*/

// approach 2,, optimal ,, time complexity --- O(N/2*N/2) + O(N*N/2),space complexity --- O(1)

    int n = matrix.length;
    // step 1 : transpose ,,, O(N/2*N/2)
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            swap(matrix,i,j);
        }
    }

    // step 2 : reverse of every row ,,, O(N*N/2)
    for(int i=0;i<n;i++){
        reverse(matrix[i],0,n-1);
    }
    }

    public void swap(int[][] matrix,int a,int b){
        int temp = matrix[a][b];
        matrix[a][b] = matrix[b][a];
        matrix[b][a] = temp;
    }

    public void reverse(int[] arr,int start,int end){
        int temp =0;
        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    /* 
    
import java.util.*;
class RotateImage {
    static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
        */
}