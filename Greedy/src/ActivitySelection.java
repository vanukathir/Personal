import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public static void main(String[] args){
        ActivitySelection obj = new ActivitySelection();
        int[][] arr = new int[][] {{1,100},{11,22},{1,11},{2,12}};
        int val = obj.nonOverlappingActivity(arr);
        System.out.println("val:"+val);
    }

    int nonOverlappingActivity(int[][] arr){
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        for(int i=0;i<arr.length;i++){
            System.out.println("arr:"+Arrays.toString(arr[i]));
        }
        int count = 0;
        int j=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i][0] != -1 && arr[i][1] != -1 && arr[j][1] > arr[i][0] ){
                count++;
                arr[j][1] = arr[i][1];

            }else if(arr[i][0] != -1){
                j++;
            }

        }
        return count;
    }
}
