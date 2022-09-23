import java.util.*;
public class Calculate {

    public static int calculate (String sol) {
        Stack<String> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < sol.length(); i++) {
            String temp = String.valueOf(sol.charAt(i));
            if (temp.equals(" ")) {
                continue;
            }
            stack1.push(temp);
        }
        while (!stack1.isEmpty()) {
            String buffer = stack1.pop();
            if (Character.isDigit(buffer.charAt(0))) {
                stack2.push(Integer.parseInt(buffer));
            }
            if (buffer.contains("+")) {
                int result = stack2.pop() + stack2.pop();
                stack2.push(result);
            }
            if (buffer.contains("-")) {
                int val1 = stack2.pop();
                int val2 = stack2.pop();
                int result = val1 - val2;
                stack2.push(result);
            }
            if (buffer.contains("*")) {
                int result = stack2.pop() * stack2.pop();
                stack2.push(result);
            }
            if (buffer.contains("/")) {
                int val1 = stack2.pop();
                int val2 = stack2.pop();
                int result = val1 / val2;
                stack2.push(result);
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        System.out.println(calculate("= + 9 * 5 + 2 8"));
    }
}
