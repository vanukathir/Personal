import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {
    public static void main(String[] args){
        LongestPalindrome lp = new LongestPalindrome();
        int val = lp.largestPalindrome("bananas");
        System.out.println(val);
    }

    int largestPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
              int  value =  map.get(s.charAt(i)) ;
               map.put(s.charAt(i),value+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        if(map.size() == 1)
            return s.length();
        int finalCount = 0 , OddCount = 0;
        for (Map.Entry<Character, Integer> itr : map.entrySet()) {
                if(itr.getValue() % 2 == 0){
                    finalCount+=itr.getValue();

                }else if(itr.getValue() / 2 > 0){
                    finalCount+= (itr.getValue() / 2);
                    OddCount = 1;
                }
                else
                    OddCount = 1;
            System.out.println("finalCount : "+finalCount +" "+ OddCount);
        }
        return finalCount + OddCount;
    }
}
