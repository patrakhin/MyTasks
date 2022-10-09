import java.lang.reflect.Array;
import java.util.Objects;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int step;
    public int countSlotFull;
    public int indexSlotExist;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        countSlotFull = (size - 1);
        if (size < 17) {
            step = 1; //final step
        }
        if (size >= 17) {
            step = 3;
        }

    }

    public int hashFun(String key)
    {
        String valueKey = key.trim();
        int sumCode = 0;
        for (int i = 0; i < valueKey.length(); i++) {
            char j = valueKey.charAt(i);
            sumCode = sumCode + j;
        }
        return (((sumCode) % step) % size);
    }

    public boolean isKey(String key)
    {
        String clearString = key.trim();
        for (int i = 0; i < size; i ++) {
            if (Objects.equals(slots[i], clearString)) {
                this.indexSlotExist = i;
                return true;
            }
        }
        // return true if key exist ,
        // else false if key don't exist
        return false;
    }

    public int seekFreeSlot (String keyTrim) {
        String clearString = keyTrim.trim();
        int slotKey = hashFun(clearString);
        int placePut = 0;
        for (; placePut < (size * step); slotKey +=step, placePut++ ) {
            if (slotKey > (size - 1)) {
                slotKey = slotKey - size;
            }
            if (slots[slotKey] == null) {
                slots[slotKey] = keyTrim;
                return slotKey;  // indexSlot;  // seek empty slot
            }
            if (slotKey == (size - 1)) {
                slotKey = (step - 1);
            }
        }
        return size + 1; // Array is full
    }

    public void put(String key, T value)
    {
        String clearString = key.trim();
        boolean  existKey = isKey(clearString);
        //key is exist  - values will rewrite
        if (existKey) {
            values [indexSlotExist] = value;
            countSlotFull --;
        }
        //key doesn't exist  - value will write with this key
        if (!existKey) {
            values [seekFreeSlot(clearString)] = value;
            countSlotFull --;
        }
        // sure writing
        // value "value" at key "key"
    }

    public T get(String key)
    {
        String clearString = key.trim();
        boolean  existKey = isKey(clearString);
        if (existKey) {
            return values [indexSlotExist];
        }
        // return value for key,
        // or null if key not found
        return null;
    }
}