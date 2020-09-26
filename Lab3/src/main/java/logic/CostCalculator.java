package logic;

import model.Squad;
import model.Weapon;

import java.util.LinkedList;
import java.util.List;

public class CostCalculator {

    static int calculate(Squad squad) {
        List<Weapon> arming= new LinkedList<Weapon>(squad.getArming());
        int resultCost = 0;
        for(Weapon weapon: arming) {
            resultCost += weapon.getCost();
        }
        return resultCost;
    }

}
