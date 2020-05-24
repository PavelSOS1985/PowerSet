import java.util.ArrayList;

public class PowerSet {
    ArrayList<String> powerSetList;

    // ваша реализация хранилища
    public PowerSet() {
        powerSetList = new ArrayList<>(20000);
    }

    // количество элементов в множестве
    public int size() {
        return powerSetList.size();
    }


    // всегда срабатывает
    public void put(String value) {
        if (!powerSetList.contains(value)) powerSetList.add(value);
    }

    // возвращает true если value имеется в множестве,
    // иначе false
    public boolean get(String value) {
        return powerSetList.contains(value);
    }

    // получить элемент
    public String getEl(int i) {
        return powerSetList.get(i);
    }


    // возвращает true если value удалено
    // иначе false
    public boolean remove(String value) {
        return powerSetList.remove(value);
    }

    // пересечение текущего множества и set2
    public PowerSet intersection(PowerSet set2) {
        PowerSet newPowerSet = new PowerSet();
        for (String i :
                powerSetList) {
            if (set2.get(i)) newPowerSet.put(i);
        }
        return newPowerSet;
    }

    // объединение текущего множества и set2
    public PowerSet union(PowerSet set2) {
        PowerSet newPowerSet = new PowerSet();
        for (String i :
                powerSetList) {
            newPowerSet.put(i);
        }
        for (int i = 0; i < set2.size(); i++) {
            newPowerSet.put(set2.getEl(i));
        }
        return newPowerSet;
    }

    // разница текущего множества и set2
    public PowerSet difference(PowerSet set2) {
        PowerSet newPowerSet = new PowerSet();
        for (String i :
                powerSetList) {
            if (!set2.get(i)) newPowerSet.put(i);
        }
        return newPowerSet;
    }

    // возвращает true, если set2 есть
    // подмножество текущего множества,
    // иначе false
    public boolean isSubset(PowerSet set2) {
        for (int i = 0; i < set2.size(); i++) {
            if(!powerSetList.contains(set2.getEl(i))) return false;
        }
        return true;
    }
}