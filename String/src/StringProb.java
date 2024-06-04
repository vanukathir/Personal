import java.util.HashMap;
import java.util.function.Predicate;

public class StringProb {

    public static void main(String[] args){
        StringProb obj = new StringProb();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I' ,1);
        map.put('V' , 5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int val = obj.romanNumbers(map,"MCMXCIV");
        System.out.println("Sum of roman numbers:"+val);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("score of a string");
        String s = "hello";
        val = obj.scoreString(s);
        System.out.println("val:"+val);
        System.out.println("################");
        val = obj.appendCharacters("coaching","coding");
        System.out.println(val);
    }
    public int appendCharacters(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        char ch[] = t.toCharArray();
        System.out.println(sb.indexOf(t));
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == t.charAt(0)){
                for(int j = i;j<t.length();j++){
                    if(sb.charAt(j) != t.charAt(j)){
                        return t.length()-j;
                    }
                }
            }
        }
        return 0;
    }
    int scoreString(String s){
        int prev = s.charAt(0),target = 0;
        for(int i=1;i<s.length();i++){
            int score = prev - s.charAt(i);
            System.out.println("Score:"+score);
            prev = s.charAt(i);
            target += (score > 0 ? score : -(score));
        }
        return target;
    }
    int romanNumbers(HashMap<Character,Integer> map,String input){
        StringBuilder sb = new StringBuilder(input);
        int sum = 0 , prev = map.get(sb.charAt(0));
        for(int i=1;i<sb.length();i++){
            if(map.containsKey(sb.charAt(i))){
                if(map.get(sb.charAt(i)) < prev) {
                    sum += prev;
                }
                else{
                    sum -= prev;
                }
                prev = map.get(sb.charAt(i));
            }

        }
        return sum;
    }
}
