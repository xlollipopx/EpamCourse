package view;

import logic.CostCalculator;
import model.Squad;

public class SquadCharacteristicsViewer implements Viewer {
    public void view(Squad squad) {
        System.out.println(squad.toString());
    }

    public void viewArmingCost(Squad squad) {
        CostCalculator costCalculator = new CostCalculator();
        System.out.println(costCalculator.calculate(squad));
    }
}
