import java.util.Arrays;

public class DP {

    public static void main(String[] args){
        DP dp = new DP();
        System.out.println(" Counting Bits0");
        int[] arr = dp.countBits(5);
        System.out.println(Arrays.toString(arr));

    }

    int[] countBits(int n){
        int temp = 0;
        int[] arr = new int[n];
        for(int i=1;i<=n;i++){
            int count = 0;
            int no = i;
             while(no > 0){
                 int digit = no % 2;
                 if(digit == 1){
                     count++;
                 }
                 no = no / 2;
             }
             System.out.println("index" + temp + "i" + i);
             arr[temp++] = count;
        }
        return arr;
    }
}
