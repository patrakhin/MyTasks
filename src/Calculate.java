import java.util.*;
public class Calculate {

    public static int calculating (String sol) {
        Stack<String> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int val1 = 0;
        int val2 = 0;
        int result = 0;
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
            if (buffer.contains("=")) {
                break;
            }
            if (!Character.isDigit(buffer.charAt(0))) {
                val1 = stack2.pop();
                val2 = stack2.pop();
            }
            if (buffer.contains("+")) {
                result = val1 + val2;
            }
            if (buffer.contains("-")) {
                result = val1 - val2;
            }
            if (buffer.contains("*")) {
                result = val1 * val2;
            }
            if (buffer.contains("/")) {
                result = val1 / val2;
            }
            if (!Character.isDigit(buffer.charAt(0))) {
                stack2.push(result);
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        System.out.println(calculating("= + 9 * 5 + 2 8"));
    }
}
