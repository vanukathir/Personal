import java.lang.Math;

public class NumberProblems {


    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int operations = 0;
        int i = 0;
        while(sb.length() > 1){
            if(sb.charAt(sb.length()-1) == '0')
                removeChar(sb.length()-1,sb);
            else
                addOne(sb);
            operations++;
        }
        return operations;
    }
    void addOne(StringBuilder sb){
        int lastZero = 0,index = sb.length()-1;

        while(index >= 0 && sb.charAt(index) != '0'){
            sb.setCharAt(index,'0');
            index--;
        }
        if(index < 0){
            sb.insert(0,'1');
        }else {
            sb.setCharAt(index,'1');
        }

    }
    void removeChar(int length, StringBuilder sb){
        sb.deleteCharAt(length);

    }

    public static void main(String[] args) {
        NumberProblems num = new NumberProblems();
       // int count = num.numSteps("1111110011101010110011100100101110010100101110111010111110110010");
        int count = num.numSteps("1101");
        System.out.println(count);
    }
}
