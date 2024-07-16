import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceProblems {
    public boolean areNumbersAscending(String s) {
        int no = Integer.MIN_VALUE;
        String[] splited = s.split(" ");
        for(int i=0;i<splited.length;i++){
            String word = splited[i];
            if(onlyDigits(word)){
                if(no < Integer.parseInt(word)){
                    no = Integer.parseInt(word);
                }else
                    return false;
            }
        }
        return true;
    }

    public boolean onlyDigits(String str){
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        if(str == null)
            return false;
        Matcher m = p.matcher(str);
        return m.matches();
    }
    public static void main(String[] args){
        SentenceProblems obj = new SentenceProblems();
        boolean result = obj.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles");
        System.out.println("result:"+result);
    }
}
