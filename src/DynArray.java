import java.lang.reflect.Array;
import java.util.*;
public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;
    public T [] oldArray;

    public DynArray(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index == 0 || index <= array.length - 1) {
            T t = array[index];
            return t;
        }
        return null;
    }
    public T[] copyArray () {
        oldArray = this.array;
        //System.arraycopy(array, 0, oldArray, 0, array.length);
        return oldArray;
    }

    public void append(T itm)
    {
        boolean flagEmpty = count + 1 <= capacity;
        if (flagEmpty) {
            array [count] = itm;
            count ++;
            return;
        }
        copyArray();
        makeArray(capacity * 2);
        System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        array [count] = itm;
        count ++;
    }

    public void insert(T itm, int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(index);
        }
        boolean flagDontGrow = false;
        if (index < capacity) {
            copyArray();
            makeArray(capacity);
        }
        if (index == 0) { // insert head
            array [index] = itm;
            System.arraycopy(oldArray, 0, array, index + 1, oldArray.length - 1);
            flagDontGrow = true;
        }
        if (index == capacity -  1 && !flagDontGrow) { // insert tail
            System.arraycopy(oldArray, 0, array, 0, oldArray.length - 1);
            array [index] = itm;
            flagDontGrow = true;
        }
        if ((index > 0 && index < capacity) && !flagDontGrow) { // insert any place
            System.arraycopy(oldArray, 0, array, 0, index);
            array [index] = itm;
            System.arraycopy(oldArray, index , array, index + 1, oldArray.length - 1 - index);
        }

        if (index >= capacity ) {
            copyArray();
            makeArray(capacity * 2);
            System.arraycopy(oldArray, 0, array, 0, index);
            array [index] = itm;
            System.arraycopy(oldArray, index, array, index + 1, oldArray.length - index);
        }
        count ++;
    }

    public void remove(int index) throws IndexOutOfBoundsException
    {
        boolean reSize = false;
        boolean cutSize = false;
        if (index < 0 && index > count - 1) {
            throw new IndexOutOfBoundsException(index);
        }
        int currentCapacity = (int) (capacity / 1.5);
        if (currentCapacity < 16) {
            currentCapacity = 16;
        }
        if ((count - 1 <= currentCapacity) && capacity > 16 && (count - 1 < capacity/2)) {
            reSize = true;
        }

        if ((index == 0)) { //head
            copyArray();
            makeArray(capacity);
            System.arraycopy(oldArray, index + 1, array, 0, oldArray.length - 1);
            count --;
            cutSize = true;

        }
        if ((index == (count - 1)) && !cutSize) { // tail
            copyArray();
            makeArray(capacity);
            System.arraycopy(oldArray, 0, array, 0, (index));
            count --;
            cutSize = true;

        }
        if ((index < count && index > 0) && !cutSize) { // any place
            copyArray();
            makeArray(capacity);
            System.arraycopy(oldArray, 0, array, 0, index);
            System.arraycopy(oldArray, index + 1, array, index, oldArray.length - (index + 1));
            count --;

        }
        if (reSize) {
            copyArray();
            makeArray(currentCapacity);
            System.arraycopy(oldArray, 0, array, 0, count);
            this.capacity = currentCapacity;
        }
    }
}