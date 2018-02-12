package Medium;

import java.util.Stack;

public class _150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if (tokens[i].equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if (tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
