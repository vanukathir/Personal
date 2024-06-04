import java.util.Stack;

public class RemoveOutermostParenthesis {

    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));

            }else if(s.charAt(i) == ')'){
                if(stack.size() > 1){
                    result.append(stack.pop().toString()+ s.charAt(i));
                }else if(stack.size() == 1){
                    stack.pop();
                }

            }

        }
        return result.toString();
    }

    public static void main(String[] args){
        RemoveOutermostParenthesis obj = new RemoveOutermostParenthesis();
        System.out.println(obj.removeOuterParentheses("(()())(())"));
    }
}
