package data;

import model.Squad;
import model.Weapon;

import java.util.List;

public interface SquadCreatorFactory {
    Squad create();
    Squad create(List<Weapon> arming);
}
