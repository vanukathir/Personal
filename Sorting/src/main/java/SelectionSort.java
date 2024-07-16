import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args){
        SelectionSort sort = new SelectionSort();
        int[] arr = {13,45,2,52,20,9};
        arr = sort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    int[] selectionSort(int[] arr){
        int minVal = arr[0];
        int minIndex = 0;
        for(int i=0;i<arr.length;i++){
            minVal = arr[i];
            minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(minVal > arr[j]){
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            int temp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
