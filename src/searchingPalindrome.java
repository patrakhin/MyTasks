import Deque.*;
public class searchingPalindrome {
    public static boolean searching (Deque deque) {
        int middle = deque.size() / 2;
        for ( ; middle > 0; ) {
            if (!deque.removeFront().equals(deque.removeTail())) {
                return false;
            }
            middle --;
        }
        return true;
    }
    public static void main(String[] args) {
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(9);
        deque.addFront(9);
        deque.addFront(2);
        deque.addFront(1);
        System.out.println(searching(deque));
    }
}
