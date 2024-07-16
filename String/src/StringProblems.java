import java.util.*;


public class StringProblems {

    public static void main(String[] args){
        StringProblems sp = new StringProblems();
        System.out.println("Single word keyboard");
        int val = sp.calculateTime("abcdefghijklmnopqrstuvwxyz" , "cba");
        System.out.println(val);
        String result = sp.minRemoveToMakeValid("))((");
        System.out.println("Minimum Remove to Make Valid Parentheses: " + result);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ valid-word-abbreviation");
        boolean flag = sp.validWordAbbreviation("internationalization","i12iz4n");
        System.out.println(flag);
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int sIndex = -1, eIndex = -1, start = 0;
        while(start < word.length()){
            if(word.charAt(start) == abbr.charAt(start)){
                if(sIndex != -1 && eIndex != -1){
                    String s = new String();
                    for(int i = sIndex;i<=eIndex;i++){
                        s+= abbr.charAt(i);
                    }
                    start +=  Integer.getInteger(s);
                }
                else if(sIndex != -1){
                    char s = abbr.charAt(sIndex);
                    start += (int)s;
                    System.out.println("start Index:"+start);
                }
                sIndex = -1;
                eIndex = -1;
            }else if(word.charAt(start) != abbr.charAt(start)){
                if(sIndex == -1){
                    sIndex = start;
                }else{
                    eIndex = start;
                }
            }
            start++;
        }
        if(sIndex != -1 || eIndex != -1)
            return false;
        else
            return true;

    }

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == '(')
                stack.push(i);
            else if(sb.charAt(i) == ')') {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    sb.delete(i,i+1);
            }
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }
    public String interpret(String command) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("G" , "G");
        map.put("()","o");
        map.put("(al)","al");
        String result = new String();
        for(int i=0;i<command.length();i++){
            if(command.charAt(i) == 'G'){
                result += command.charAt(i);
            }else if(command.charAt(i++) == '('){
                if(i<command.length() && command.charAt(i) == ')'){
                    result += map.get("()");
                }else if(i< command.length() && command.charAt(i) == 'a'){
                    result += map.get("(al)");
                }
            }
        }
        return result;
    }
    public int calculateTime(String keyboard, String word) {
        int total = 0 , prevIndex = 0;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = keyboard.indexOf(c) ;

            int res = Math.abs(prevIndex - index);
            prevIndex = index;
            total += res;
        }
        return total;
    }

    void findPermutations(char[] c){
        int l = 0, r=c.length-1;
        for(int i=l;i<=r;i++){
            System.out.println(Arrays.toString(c));
            swap(i,r,c);
            findPermutations(c);
            swap(i,r,c);
        }

    }

    void swap(int left,int right, char[] c){
        char temp = c[left];
        c[left] = c[right];
        c[right] = temp;
    }
}
