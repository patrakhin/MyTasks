import java.util.*;
public class PowerSet
{
    public String [] slots;
    public int count;
    public boolean flagNull = false;
    public int sizze = 20000;

    public PowerSet()
    {
        slots = new String[sizze];
        for(int i=0; i<20000; i++) slots[i] = null;
        this.count = 0;
    }

    public int size()
    {
        return count;
    }

    //it's my insert
    public int hashFun(String value)
    {
        String valueString = value.trim();
        int sumCode = 0;
        for (int i = 0; i < valueString.length(); i++) {
            char j = valueString.charAt(i);
            sumCode = sumCode + j;
        }
        return (((sumCode) % 3) % 20000);
    }

    public int seekSlot(String value)
    {
        flagNull = false;
        String clearString = value.trim();
        int indexSlot = hashFun(clearString);
        int placePut = 0;
        for (; placePut < (20000 * 3); indexSlot +=3, placePut++ ) {
            if (indexSlot > (20000 - 1)) {
                indexSlot = indexSlot - 20000;
            }
            if (slots [indexSlot] == null) {
                flagNull = true;
                return indexSlot;  // seek empty slot
            }
            if (Objects.equals(slots[indexSlot], clearString)) {
                return indexSlot;  // its equals
            }
            if (indexSlot == (20000 - 1)) {
                indexSlot = (3 - 1);
            }
        }
        return -1; //all full
    }
    // end  insert
    public void put(String value)
    {
        String clearString = value.trim();
        int slotPut = seekSlot(clearString);
        if (flagNull) {
            slots[slotPut] = clearString;
            flagNull = false;
            count ++;
        }
        // always work
    }

    public boolean get(String value)
    {
        String clearString = value.trim();
        int indexEmptySlot = seekSlot(clearString);
        if (indexEmptySlot > -1 && !flagNull) {
            return true;
        }
        return false;
        // return true if value is into PowerSet,
        // else false
    }

    public boolean remove(String value)
    {
        boolean flagRemove = false;
        PowerSet powerRemove = new PowerSet();
        powerRemove.sizze = count - 1;
        String clearString = value.trim();
        int indexEmptySlot = seekSlot(clearString);
        if (indexEmptySlot > - 1 && !flagNull) {
            slots[indexEmptySlot] = null;
            flagRemove = true;
        }
        for (int j = 0; j < count && flagRemove; j ++) {
            if (slots[j] == null) {
                continue;
            }
            powerRemove.put(slots[j]);
        }
        if (flagRemove) {
            count--;
            return true;
        }
        // return true if value deleted
        // else false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet listIntersection = new PowerSet();
        if (count == 0) {
            return listIntersection;
        }
        for (int i = 0; i < set2.size(); i++) {
            if (set2.slots[i] == null) {
                continue;
            }
            String stringForPut = set2.slots[i];
            for (int j = 0; j < size(); j++) {
                String stringSeek = slots[j];
                if (Objects.equals(stringSeek, stringForPut)) {
                    listIntersection.put(stringForPut);
                }
            }
        }
        // intersection the powerSet and set2
        return listIntersection; // return empty  Power Set but not null!!!!
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet listUnion = new PowerSet();
        if (count == 0) {
            return set2;
        }
        if (set2.count == 0) {
            listUnion.slots = slots;
            listUnion.count = count;
            return listUnion;
        }
        listUnion.slots = slots;
        listUnion.count = count;
        for (int i = 0; i< 20000; i++) {
            if (set2.slots[i] == null) {
                continue;
            }
            listUnion.put(set2.slots[i]);
        }
        return listUnion; // return empty  Power Set but not null!!!!
    }
    // difference the powerSet and set2
    public PowerSet difference(PowerSet set2)
    {
        PowerSet listIDifference = new PowerSet();
        if (count == 0) {
            return listIDifference;
        }
        for (int i = 0; i < set2.size(); i++) {
            if (set2.slots[i] == null) {
                continue;
            }
            String stringForPut = set2.slots[i];
            for (int j = 0; j < size(); j++) {
                String stringList = slots[j];
                if (slots[j] == null) {
                    continue;
                }
                if (Objects.equals(stringForPut, stringList)) {
                    slots[j] = null;
                    count --;
                }
            }
        }
        for (int k = 0; k < count; k++) {
            if (slots[k] == null) {
                continue;
            }
            listIDifference.put(slots[k]);
        }
        return listIDifference; // return empty  Power Set but not null!!!!
    }

    public boolean isSubset(PowerSet set2)
    {
        if (count == 0 || set2.count == 0) {
            return true;
        }

        int countSub = 0;
        int sizeA = count;
        int sizeB = set2.count;
        for (int i = 0; i < set2.size(); i++) {
            if (set2.slots[i] == null) {
                continue;
            }
            String stringForPut = set2.slots[i];
            for (int j = 0; j < size(); j++) {
                if (slots[j] == null) {
                    continue;
                }
                String stringList = slots[j];
                if (Objects.equals(stringForPut, stringList)) {
                    countSub ++;
                }
            }
        }
        if (sizeA > sizeB && countSub == sizeB) {
            return true;
        }
        if (sizeA < sizeB && countSub == sizeA) {
            return true;
        }
        return sizeA == sizeB && countSub == sizeA;
        // return true, if set2 is
        // subSet this pSet,
        // else false
    }
}