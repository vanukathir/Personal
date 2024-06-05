import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TwoPair {
    public static void main(String[] args){
        TwoPair tp = new TwoPair();
        List<Integer> arr = Arrays.asList(-1,1,2,3,1);
        int val = tp.countNoOfPairs(arr,2);
        System.out.println(val);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Reverse Prefix of Word");
        String result = tp.reversePrefix("abcdefg",'d');
        System.out.println(result);
    }

    String reversePrefix(String word,char ch){
        StringBuilder sb = new StringBuilder(word);
        int i=0;
        for( i=0;i<sb.length();i++){
            if(sb.charAt(i) == ch){
                break;
            }
        }
         sb = reverseString(sb.substring(0,i+1)).append(sb.substring(i+1));
        return sb.toString();
    }
    StringBuilder reverseString(String s){
        StringBuilder rev  = new StringBuilder(s);
        rev.reverse();
        return rev;
    }

    int countNoOfPairs(List<Integer> arr,int target){
        int count = 0;
        for(int i=0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                if(target < arr.get(i) + arr.get(j))
                    count++;
            }
        }
        return count;
    }
}
