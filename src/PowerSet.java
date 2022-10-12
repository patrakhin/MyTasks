import java.util.*;
public class PowerSet
{
    private final List <String> listPowerSet;
    private int count;
    public PowerSet()
    {
        listPowerSet =  new ArrayList<>();
        count = 0;
    }

    public int size()
    {
        return listPowerSet.size();
    }

    //it's my insert
    public int seekIndex (String value)
    {
        String clearString = value.trim();
        for (int i = 0; i < listPowerSet.size(); i++) {
            if (Objects.equals(clearString, listPowerSet.get(i))) {
                return 1;
            }
        }
        return -1;
    }
    // end  insert
    public void put(String value)
    {
        String clearString = value.trim();
        if (listPowerSet.isEmpty()) {
            listPowerSet.add(clearString);
            count ++;
            return;
        }
        int indexEmptySlot = seekIndex(clearString);
        if (indexEmptySlot == -1) {
            count ++;
            listPowerSet.add(clearString);
        }
        if (indexEmptySlot > -1) {
            listPowerSet.add(indexEmptySlot, clearString);
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
            listPowerSet.remove(clearString);
            return true;
        }
        // return true if value deleted
        // else false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet listIntersection = new PowerSet();
        if (listPowerSet.isEmpty()) {
            set2 = new PowerSet();
            return set2;
        }
        for (int i = 0; i < set2.size(); i++) {
            String stringForPut = set2.listPowerSet.get(i);
            for (int j = 0; j < listPowerSet.size(); j++) {
                String stringList = listPowerSet.get(j);
                if (Objects.equals(stringForPut, stringList)) {
                    listIntersection.listPowerSet.add(stringList);
                    listPowerSet.remove(j);
                }
            }
        }
        set2 = listIntersection;
        // intersection the powerSet and set2
        return set2; // return empty  Power Set but not null!!!!
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet listUnion = new PowerSet();
        boolean flagPut = false;
        for (int i = 0; i < set2.size(); i++) {
            String stringForPut = set2.listPowerSet.get(i);
            for (int j = 0; j < listPowerSet.size(); j++) {
                String stringList = listPowerSet.get(j);
                if (Objects.equals(stringForPut, stringList)) {
                    listUnion.listPowerSet.add(stringList);
                    listPowerSet.remove(j);
                    flagPut = true;
                }
            }
            if (!flagPut) {
                listUnion.listPowerSet.add(stringForPut);
            }
            flagPut = false;
        }
        listUnion.listPowerSet.addAll(listPowerSet);
        set2 = listUnion;
        return set2; // return empty  Power Set but not null!!!!
    }
    // difference the powerSet and set2
    public PowerSet difference(PowerSet set2)
    {
        PowerSet listIDifference = new PowerSet();
        for (int i = 0; i < set2.size(); i++) {
            String stringForPut = set2.listPowerSet.get(i);
            for (int j = 0; j < listPowerSet.size(); j++) {
                String stringList = listPowerSet.get(j);
                if (Objects.equals(stringForPut, stringList)) {
                    listPowerSet.remove(j);
                }
            }
        }
        listIDifference.listPowerSet.addAll(listPowerSet);
        set2 = listIDifference;
        return set2; // return empty  Power Set but not null!!!!
    }

    public boolean isSubset(PowerSet set2)
    {
        boolean flagPut = false;
        int countSub = set2.size();
        for (int i = 0; i < set2.size(); i++) {
            String stringForPut = set2.listPowerSet.get(i);
            for (int j = 0; j < listPowerSet.size(); j++) {
                String stringList = listPowerSet.get(j);
                if (Objects.equals(stringForPut, stringList)) {
                    listPowerSet.remove(j);
                    countSub --;
                    flagPut = true;
                }
            }
            if (!flagPut) {
                countSub ++;
            }
            flagPut = false;
        }
        return (!listPowerSet.isEmpty() && countSub == 0) || (listPowerSet.isEmpty() && countSub == 0);
        // return true, if set2 is
        // subSet this pSet,
        // else false
    }
}