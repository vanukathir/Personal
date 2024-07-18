import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        InsertionSort sort = new InsertionSort();
        int[] arr = {13,46,24,52,20,9};
        arr = sort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    int[] insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
