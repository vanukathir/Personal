import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class RemoveOutermostParaenthesis {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == '(') {

                if(stack.size() > 0){
                    sb.append(c);
                }
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if(stack.size() >0) {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }
        static public void main(String[] args){
            RemoveOutermostParaenthesis obj = new RemoveOutermostParaenthesis();
            String ios = obj.removeOuterParentheses("(()())(())(()(()))");
            System.out.print(ios);
        }
    }

