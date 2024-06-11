import java.util.Arrays;

public class PascalTriangle {
    public static void main(String[] args){
        PascalTriangle pt = new PascalTriangle();
        int[][] arr = pt.pascalTriangle(10);
        pt.print2DArray(arr);
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
        return arr;
    }
}
