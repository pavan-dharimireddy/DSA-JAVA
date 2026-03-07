import java.util.Scanner;

// this kadane algo gives the result of sub array  of maximum sum 
public class kadane_algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] result = kadane(arr, n);
        for(int i = result[0];i<=result[1];i++)
        System.out.println(arr[i]);
        System.out.println(result[2]);
        sc.close();




    }

    public static int[] kadane(int [] arr, int n){

        int cur_sum = 0;
        int max_sum = 0;
        int start = 0;
        int end=0;
        for(int i = 0; i<n;i++){
            
            cur_sum = cur_sum + arr[i];
            if (cur_sum > max_sum){
                max_sum = cur_sum;
                end = i;
            }

            if (cur_sum < 0){
                cur_sum = 0;
                if (i != n-1){
                    start = i+1;

                }
            }
            

        }
        return new int[]{start,end,max_sum};
    }
}
