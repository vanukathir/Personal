import java.util.Stack;

public class MaxDeepParathensis {
        int maxDepth(String s) {
            int count = 0;
            Stack<Character> stack = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c == '(')
                    stack.push(c);
                else if (c == ')')
                    stack.pop();
                count = Math.max(count, stack.size());
            }
            return count;
        }

}
