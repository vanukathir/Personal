import java.util.HashSet;

public class ArrayListOfProb {
    public static void main(String[] args){
        ArrayListOfProb obj = new ArrayListOfProb();
        int arr[] = {10,4,3,50,23,90};
        System.out.println("Find the largest 3 distinct elements in array");
        obj.find3Largest(arr);
        System.out.println("Find Missing Element In array");
        arr = new int[]{1, 2, 4, 6, 3, 7, 8};
        int n = 8;
        int val = obj.findMissing(arr,n);
        System.out.println(val);
        System.out.println("#########################");
        System.out.println("find first repeating element in arr");
        arr = new int[] {6, 10, 5, 4, 9, 120, 4, 6, 10};
        val = obj.findFirstRepeatElement(arr);
        System.out.println(val);
    }

    int findFirstRepeatElement(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int min = -1;
        for(int i=arr.length-1;i>=0;i--){
            if(set.contains(arr[i]))
                min = i;
            set.add(arr[i]);
        }
        return arr[min];
    }

    int findMissing(int[] arr,int n){
        int total = n* (n+1) / 2;
        for(int i=0;i<arr.length;i++){
            total -=arr[i];
        }
        return total;
    }

    void find3Largest(int[] arr){
        int largest = 0, larger = 0,large =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > large){
                if(arr[i] > larger){
                    if(arr[i] > largest){
                        large = larger;
                        larger = largest;
                        largest = arr[i];
                    }else if(arr[i] < largest){
                        large = larger;
                        larger = arr[i];
                    }
                }else if(arr[i] < larger){
                    large = larger;
                    larger = arr[i];
                }
            }
        }
        System.out.println("largest:"+largest);
        System.out.println("larger:"+larger);
        System.out.println("large:"+large);
    }
}
