import java.util.*;
public class PowerSet
{
    public List <String> storage;
    public PowerSet()
    {
        storage = new ArrayList<>();
    }

    public int size()
    {
        return storage.size();
    }

    public void put(String value)
    {
        String clearString = value.trim();
        if (!storage.contains(clearString)) {
            storage.add(clearString);
        }
        // always work
    }

    public boolean get(String value)
    {
        String clearString = value.trim();
        return storage.contains(clearString);
        // return true if value is into PowerSet,
        // else false
    }

    public boolean remove(String value)
    {
        String clearString = value.trim();
        if (storage.contains(clearString)) {
            storage.remove(clearString);
            return true;
        }
        // return true if value deleted
        // else false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet listIntersection = new PowerSet();
        if (storage.isEmpty() || set2.size() == 0) {
            return listIntersection;
        }
        for (int i = 0; i < set2.size(); i ++) {
            String buff = set2.storage.get(i);
            if (storage.contains(buff)) {
                listIntersection.storage.add(buff);
            }
        }
        // intersection the powerSet and set2
        return listIntersection; // return empty  Power Set but not null!!!!
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet listUnion = new PowerSet();
        if (storage.isEmpty()) {
            return set2;
        }
        if (set2.size() == 0) {
            listUnion.storage.addAll(storage);
            return listUnion;
        }
        listUnion.storage.addAll(storage);
        for (int i = 0; i < set2.size(); i ++) {
            String buff = set2.storage.get(i);
            if (!storage.contains(buff)) {
                listUnion.storage.add(buff);
            }
        }
        return listUnion; // return empty  Power Set but not null!!!!
    }
    // difference the powerSet and set2
    public PowerSet difference(PowerSet set2)
    {
        PowerSet listIDifference = new PowerSet();
        if (set2.size() == 0) {
            listIDifference.storage.addAll(storage);
            return listIDifference;
        }
        for (int i = 0; i < set2.size(); i++) {
            String buff = set2.storage.get(i);
            storage.remove(buff);
        }
        listIDifference.storage.addAll(storage);
        return listIDifference; // return empty  Power Set but not null!!!!
    }

    public boolean isSubset(PowerSet set2)
    {
        if (set2.size() == 0 && !storage.isEmpty()) {
            return true;
        }
        int countHit = 0;
        for (int i = 0; i < set2.size(); i++) {
            String buff = set2.storage.get(i);
            if (storage.contains(buff)) {
                countHit ++;
            }
        }
        if (countHit == set2.size() && countHit < storage.size()) {
            return true;
        }
        if (countHit == set2.size() && countHit == storage.size()) {
            return true;
        }
        return false;
        // return true, if set2 is
        // subSet this pSet,
        // else false
    }
}