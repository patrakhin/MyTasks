import java.util.*;
public class HashTable
{
    public int size;
    public int step;
    public String [] slots;
    public int countSlotFull;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
        countSlotFull = (size - 1);
    }

    public int hashFun(String value)
    {
        String valueString = value.trim();
        int sumCode = 0;
        for (int i = 0; i < valueString.length(); i++) {
            char j = valueString.charAt(i);
            sumCode = sumCode + j;
        }
        return (((sumCode) % step) % size);
    }

    public int seekSlot(String value)
    {
        String clearString = value.trim();
        int indexSlot = hashFun(clearString);
        if (countSlotFull == -1) {
            return -1;
        }
        int placePut = 0;
        for (; placePut < (size * step); indexSlot +=step, placePut++ ) {
            if (indexSlot > (size - 1)) {
                indexSlot = indexSlot - size;
            }
            if (slots [indexSlot] == null) {
                return indexSlot;  // seek empty slot
            }
            if (indexSlot == (size - 1)) {
                indexSlot = (step - 1);
            }
        }
        return -1;
    }

    public int put(String value)
    {
        String clearString = value.trim();
        int indexEmptySlot = seekSlot(value);
        if (indexEmptySlot == -1) {
            return -1;
        }
        if (slots[indexEmptySlot] == null) {
            slots[indexEmptySlot] = clearString;
            countSlotFull --;
            return indexEmptySlot;
        }
        return -1;
    }

    public int find(String value)
    {
        String clearString = value.trim();
        int indexSlot = hashFun(clearString);
        if (indexSlot > (size - 1)) {
            return -1;
        }
        int placePut = 0;
        for (; placePut < (size * step); indexSlot +=step, placePut++ ) {
            if (indexSlot > (size - 1)) {
                indexSlot = indexSlot - size;
            }
            if (Objects.equals(slots[indexSlot], clearString)) {
                return indexSlot;  // seek empty slot
            }
            if (indexSlot == (size - 1)) {
                indexSlot = (step - 1);
            }
        }
        return -1;
    }
}