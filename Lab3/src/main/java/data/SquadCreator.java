package data;

import model.Squad;
import model.Weapon;

import java.util.List;

public class SquadCreator implements SquadCreatorFactory{
    public Squad create() {
        return new Squad();
    }

    public Squad create(List<Weapon> arming) {
        return new Squad(arming);
    }

}
