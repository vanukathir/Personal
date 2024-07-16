import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetArray {

    List<List<Integer>> subArray(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        List<List<Integer>> prevResult = result;
        for(int i=0;i<arr.length;i++){
            int size = result.size();
            for(int j=0;j<size;j++){
                List<Integer> itr = new ArrayList<>(result.get(j));
                itr.add(arr[i]);
                result.add(itr);
            }

        }
        return result;
    }

    

    public static void main(String[] args){
        SubsetArray obj = new SubsetArray();
        int[] arr = {1,2,3};
        List<List<Integer>> result = obj.subArray(arr);

        for(List<Integer> list: result) {
            for (Integer val : list)
                System.out.print(val + " ");
            System.out.println("");
        }
    }
}
