import java.util.*;
public class queueHasTwoStack {

    public static void queueTwoStack (Stack stack1, Stack stack2) {
        int size = stack1.size();
        for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
        }
    }
    public static <T> void main(String[] args) {
        Stack stack1 = new Stack<>();
        Stack stack2 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        queueTwoStack(stack1, stack2);
        int size = stack2.size();
        for (int i = 0; i < size; i++) {
            System.out.println((T)stack2.pop());
        }



    }
}
