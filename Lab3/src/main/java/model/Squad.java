package model;

import java.util.LinkedList;
import java.util.List;

public class Squad {
    private List<Weapon> arming = new LinkedList<Weapon>();

    public Squad() {}

    public Squad(List<Weapon> arming) {
        this.arming.addAll(arming);
    }

    public void addWeapon(Weapon weapon) {
        arming.add(weapon);
    }

    public List<Weapon> getArming() {
        return arming;
    }

    public String toString() {
        String result = "";
        for(Weapon weapon: arming) {
            result += weapon.toString();
            result += '\n';
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
