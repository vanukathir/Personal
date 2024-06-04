import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args){
        ReverseArray obj = new ReverseArray();
        int arr[] = {1,2,3};
        obj.reverseArray(arr);
        System.out.println(Arrays.toString(arr));
        obj.recursiveReverse(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    void recursiveReverse(int[] arr,int s,int e){
        if(s>=e)
            return;
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        recursiveReverse(arr, s + 1, e - 1);
    }
    void reverseArray(int[] arr){
        int s= 0, e= arr.length-1;
        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
