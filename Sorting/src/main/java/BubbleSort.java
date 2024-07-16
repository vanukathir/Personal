import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        BubbleSort sort = new BubbleSort();
        int[] arr = {13,46,24,52,20,9};
        arr = sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    int[] bubbleSort(int[] arr){
        for(int i=arr.length-1;i>=0;i--){
            for(int j=i;j>=0;j--){
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
