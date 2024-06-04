import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args){
        QuickSort obj = new QuickSort();
        int[] arr = {10,80,30,90,50,40,70};
        obj.quickSort(arr,0,arr.length-1);
        System.out.println("QuickSort." + Arrays.toString(arr));

    }

    void quickSort(int[] arr,int s,int e){
        if(s < e){
            int pivot = partition(arr,s,e);
            quickSort(arr,s,pivot-1);
            quickSort(arr,pivot+1,e);
        }
    }
    int partition(int[] arr,int s,int e){
        int i=-1,j=0,pivotIndex = e;
        for(;j<=e;j++){
            if(arr[j] < arr[pivotIndex]){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[i];
        arr[i] = temp;
        return i;
    }
}
