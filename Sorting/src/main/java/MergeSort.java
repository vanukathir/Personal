import java.util.Arrays;

public class MergeSort {
    int[] arr = {13,46,24,52,20,9};
    public static void main(String[] args){
        MergeSort sort = new MergeSort();
        sort.mergeSort(sort.arr,0,sort.arr.length-1);
        System.out.println(Arrays.toString(sort.arr));
    }

    void mergeSort(int[] arr , int s,int e){
        if( s >= e) {
            return;
        }
            int mid = s + (e - s) /2 ;
            mergeSort(arr,s,mid);
            mergeSort(arr,mid+1,e);
            merge(arr,s,mid,e);
    }

    void merge(int[] arr,int s,int mid,int e){
        int left = s, right = mid+1;
        int start = 0;
        int[] temp = new int[arr.length];
        while(left <= mid && right <= e){
            if(arr[left] > arr[right]){
               temp[start++] = arr[right++];
            }else{
              temp[start++] = arr[left++];
            }
        }
        while(left <= mid){
            temp[start++] = arr[left++];
        }
        while(right <= e){
            temp[start++] = arr[right++];
        }
        start = s;
        for(int i=0;i<=e && start <= e;i++){
            arr[start++] = temp[i];
        }
    }
}
