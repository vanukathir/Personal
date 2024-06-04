import java.util.Arrays;

public class MergeSort {
    int[] arr = {4,3,1,6,9,2,5};
    public static void main(String[] args){
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(mergeSort.arr,0,mergeSort.arr.length-1);
        System.out.println(Arrays.toString(mergeSort.arr));
    }

    void mergeSort(int[] arr,int s,int e){
        if(s<e){
            int mid = e- (e-s) /2;
            mergeSort(arr,s,mid-1);
            mergeSort(arr,mid,e);
            merge(arr,s,mid,e);
        }
    }
    void merge(int[] arr,int s,int m, int e){
        int leftArrayLength = m-s;
        int rightArrayLength = e-m+1;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];
        int i = s ,leftIndex = 0;
        //Copy array elements to temp arrays.
        for(;leftIndex <leftArrayLength;leftIndex++){
            leftArray[leftIndex] = arr[i++];
        }
        int rightIndex = 0,j=m;
        for(;rightIndex <rightArrayLength;rightIndex++){
            rightArray[rightIndex] = arr[j++];
        }
        leftIndex = 0;
        rightIndex = 0;
        while(leftIndex < leftArrayLength && rightIndex <rightArrayLength){
         if(leftArray[leftIndex] > rightArray[rightIndex]){
             arr[s++] = rightArray[rightIndex++];
         }else{
             arr[s++] = leftArray[leftIndex++];
         }
        }
        while(leftIndex < leftArrayLength){
            arr[s++] = leftArray[leftIndex++];
        }
        while(rightIndex < rightArrayLength){
            arr[s++] = rightArray[rightIndex++];
        }
    }
}
