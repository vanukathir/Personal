import java.util.Arrays;

public class SortingTechnique {

    int[] bubbleSort(int[] arr,int start,int end){
        for(int i=0;i<end;i++){
            for(int j=i+1;j<end;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    int[] selectionSort(int[] arr,int start,int end){
        int min = -1;
        for(int i=start;i<end;i++){
            min = i;
            for(int j=i+1;j<end;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
    int[] recursiveSelectionSort(int[] arr,int n,int index){
        if(index == n){
            return arr;
        }
        int k =minIndex(arr,index,n-1);
        int temp = arr[k];
        arr[k] = arr[index];
        arr[index] = temp;

        return recursiveSelectionSort(arr, n, index+1);
    }

    int minIndex(int[] arr,int s,int e){
        if(s==e)
            return s;
        int k = minIndex(arr,s+1,e);
        return (arr[k] < arr[s]) ? k:s;
    }


    public static void main(String[] args) {
        SortingTechnique st = new SortingTechnique();
        System.out.println("Bubble Sort");
        int arr[] = {4,5,74,13,67,23,57};
        arr = st.bubbleSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println("selection sort");
        arr = new int[]{4,5,74,13,67,23,57};
        arr = st.selectionSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println("Recursive Selection Sort");
        arr = new int[]{4,5,74,13,67,23,57};
        st.recursiveSelectionSort(arr,arr.length,0);
        System.out.println(Arrays.toString(arr));
    }
}
