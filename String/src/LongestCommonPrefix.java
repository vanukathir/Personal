import java.util.Stack;

import static java.util.Collections.swap;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String minLengthWord = null;
        int min_length = strs[0].length();
        int indexMinLengthWord = 0;
        for (String word : strs) {

            if (min_length >= word.length()) {
                min_length = word.length();
                minLengthWord = word;
            }
            indexMinLengthWord++;
        }
        indexMinLengthWord--;
        System.out.println("minimum index length:" + indexMinLengthWord);
        System.out.println("min length word:" + minLengthWord);
        //strs = swap(strs,0,indexMinLengthWord);
        String maxPrefix = "";
        int maxLength = 0;
        for (int i = 0; i < strs.length; i++) {
            String prefix = "";
            for (int j = 0; j < minLengthWord.length(); j++) {
                if (minLengthWord.charAt(j) == strs[i].charAt(j)) {
                    prefix += minLengthWord.charAt(j);
                }
            }
            minLengthWord = prefix;
        }
        return minLengthWord;
    }

    private String[] swap(String[] strs, int s, int e) {
        String temp = strs[s];
        strs[s] = strs[e];
        strs[e] = temp;
        return strs;
    }

    public boolean isValid(String s) {
        boolean flag = false;
        Stack stack = new Stack();
        char c = '1';
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.isEmpty())
            {
                if((char)stack.pop() == '(')
                    flag = true;
                else
                    return false;
            }
            else if(s.charAt(i) == ']' && !stack.isEmpty()) {
                if((char) stack.pop() == '[')
                    flag = true;
                else
                    return false;
            }
            else if(s.charAt(i) == '}' && !stack.isEmpty()) {
                c = (char) stack.pop();
                if (c == '{')
                    flag = true;
                else
                    return false;
            } else
                return false;

        }
        if(!stack.isEmpty())
            return false;
        return flag;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"dog", "racecar", "car"};
        String result = lcp.longestCommonPrefix(strs);
        System.out.println("result:" + result);
        System.out.println("Valid Parenthesis");
        boolean flag = lcp.isValid("{[]}");
        System.out.println("flag:"+flag);
    }
}
