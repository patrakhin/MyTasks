import Deque.*;
public class searchingPalindrome {
    public static boolean searching (String string) {
        Deque deque = new Deque<>();
        for (int i = 0; i < string.length(); i++) {
            deque.addFront((int) string.charAt(i));
        }
        int middle = deque.size() / 2;
        for ( ; middle > 0; middle --) {
            if (!deque.removeFront().equals(deque.removeTail())) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String string = new String("REDIVIDER"); //peregorodka
        System.out.println(searching(string));
    }
}


