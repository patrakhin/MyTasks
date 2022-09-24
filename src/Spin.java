package Queue;
import java.util.*;
public class Spin {

    public static <T> void queueSpin (int item, Queue queue) {
        for (int i = 0; i < item; i++) {
            T value = (T) queue.dequeue();
            queue.enqueue(value);
        }
    }

    public static <T> void main(String[] args) {
        Queue queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        int size = queue.size();
        queueSpin(1, queue);
        for (int i = 0; i < size; i++) {
            System.out.println((T)queue.dequeue());
        }
    }
}
