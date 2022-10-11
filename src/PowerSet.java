import java.util.*;
public class PowerSet
{
    public  List list;
    private int count;
    public PowerSet()
    {
        list =  new ArrayList <>();
        count = 0;
    }

    public int size()
    {
        return list.size();
    }

    //it's my insert
    public int seekIndex (String value)
    {
        String clearString = value.trim();
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(clearString, list.get(i))) {
                return 1;
            }
        }
        return -1;
    }
    // end  insert
    public void put(String value)
    {
        String clearString = value.trim();
        if (list.isEmpty()) {
            list.add(clearString);
            count ++;
            return;
        }
        int indexEmptySlot = seekIndex(clearString);
        if (indexEmptySlot == -1) {
            count ++;
            list.add(clearString);
        }
        if (indexEmptySlot > -1) {
            list.add(indexEmptySlot, clearString);
        }
        // always work
    }

    public boolean get(String value)
    {
        String clearString = value.trim();
        int indexEmptySlot = seekIndex(clearString);
        return indexEmptySlot > -1;
        // return true if value is into PowerSet,
        // else false
    }

    public boolean remove(String value)
    {
        String clearString = value.trim();
        int indexEmptySlot = seekIndex(clearString);
        if (indexEmptySlot > -1) {
            list.remove(clearString);
            return true;
        }
        // return true if value deleted
        // else false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet listIntersection = new PowerSet();
        for (int i = 0; i < set2.size(); i++) {
            String stringForPut = (String) set2.list.get(i);
            for (int j = 0; j < list.size(); j++) {
                String stringList = (String) list.get(j);
                if (Objects.equals(stringForPut, stringList)) {
                    listIntersection.list.add(stringList);
                    list.remove(j);
                }
            }
        }
        // intersection the powerSet and set2
        return listIntersection; // return empty  Power Set but not null!!!!
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet listUnion = new PowerSet();
        boolean flagPut = false;
        for (int i = 0; i < set2.size(); i++) {
            String stringForPut = (String) set2.list.get(i);
            for (int j = 0; j < list.size(); j++) {
                String stringList = (String) list.get(j);
                if (Objects.equals(stringForPut, stringList)) {
                    listUnion.list.add(stringList);
                    list.remove(j);
                    flagPut = true;
                }
            }
            if (!flagPut) {
                listUnion.list.add(stringForPut);
            }
            flagPut = false;
        }
        listUnion.list.addAll(list);
        return listUnion; // return empty  Power Set but not null!!!!
    }
    // difference the powerSet and set2
    public PowerSet difference(PowerSet set2)
    {
        PowerSet listIDifference = new PowerSet();
        for (int i = 0; i < set2.size(); i++) {
            String stringForPut = (String) set2.list.get(i);
            for (int j = 0; j < list.size(); j++) {
                String stringList = (String) list.get(j);
                if (Objects.equals(stringForPut, stringList)) {
                    list.remove(j);
                }
            }
        }
        listIDifference.list.addAll(list);
        return listIDifference; // return empty  Power Set but not null!!!!
    }

    public boolean isSubset(PowerSet set2)
    {
        boolean flagPut = false;
        int countSub = set2.size();
        for (int i = 0; i < set2.size(); i++) {
            String stringForPut = (String) set2.list.get(i);
            for (int j = 0; j < list.size(); j++) {
                String stringList = (String) list.get(j);
                if (Objects.equals(stringForPut, stringList)) {
                    list.remove(j);
                    countSub --;
                    flagPut = true;
                }
            }
            if (!flagPut) {
                countSub ++;
            }
            flagPut = false;
        }
        return (!list.isEmpty() && countSub == 0) || (list.isEmpty() && countSub == 0);
        // return true, if set2 is
        // subSet this pSet,
        // else false
    }
}