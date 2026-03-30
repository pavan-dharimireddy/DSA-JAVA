
import java.util.Arrays;

class Heapify_of_Array{

    public static void main(String[] args) {
    int[] arr = new int[]{20,10,30,5,50,40};
    int n = arr.length-1;
    System.out.println("Before Heapify ---- > " + Arrays.toString(arr));
    for(int i=n/2;i>0;i--){
        heapify(arr, n, i);
    }
    System.out.println("After Heapify ---- > " + Arrays.toString(arr));
    
}


public static void heapify(int[] arr,int n,int i){
    int largest = i;
    int left = 2*i;
    int right = 2*i + 1;
    if(left<=n && arr[left]>arr[largest]){
        largest = left;
    if(right<=n && arr[right]>arr[largest]){
        largest = right;
    }
    if(largest!=i){
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr,n,largest);
    }
}
}
}
