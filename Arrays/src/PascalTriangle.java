import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class PascalTriangle {
    public static void main(String[] args){
        PascalTriangle pt = new PascalTriangle();
        //int[][] arr = pt.pascalTriangle(10);
        //pt.print2DArray(arr);
        List<List<Integer>> res = pt.generate(5);
        System.out.println("print pascal triagele");
        System.out.println("$##########################");
        for(List itr: res)
            for(Object val : itr){
                System.out.println(val);
            }
    }
    void print2DArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }

    int[][] pascalTriangle(int n){
        int[][] arr = new int[n+1][];
        int j=0;
        for(int i=1;i<=n+1;i++){
            int[] temp = new int[i];
            temp[0] = 1;
            temp[i-1] = 1;
            int index =0;
            for(int k=1;k<i-1;k++){
                int left = arr[i-2][index++];
                int right =  arr[i-2][index];
                temp[k] =  left+right;
            }
            arr[j++] = temp;
        }
        Arrays.asList(arr);
        return arr;
    }


    public List<List<Integer>> generate(int numRows) {
        int index = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(index <= numRows){
            Integer[] sol = new Integer[index+1];
            sol[0] = 1;
            if(index > 1)
                sol[index] = 1;
            int startIndex = 2;
            List<Integer> prevRow = null;
            Integer[] prevRowArray = null;
            if(result.size() > 2){
                prevRow  = result.get(index-1);
                prevRowArray = (Integer[]) prevRow.toArray();
                System.out.println(Arrays.toString(prevRowArray));
            }
            while(index > 2 && startIndex < index){
                int temp = prevRowArray[startIndex-1] + prevRowArray[startIndex];
                sol[startIndex] = temp;
                startIndex++;
            }
            result.add(Arrays.asList(sol));
            index++;
        }
        return result;
    }
}
