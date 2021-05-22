package сom.epam.task.eight.data.factory;

import сom.epam.task.eight.model.Magazine;
import сom.epam.task.eight.model.NewsPaper;
import сom.epam.task.eight.model.Paper;
import сom.epam.task.eight.model.ScienceMagazine;

public class PaperFactory {

    private final String NEWSPAPER = "newspaper";
    private final  String MAGAZINE = "magazine";
    private final String SCIENCE_MAGAZINE = "science-magazine";

    public Paper create(String name) {
        Paper paper;
        switch(name) {
            case NEWSPAPER:
                return new NewsPaper();
            case MAGAZINE:
                return new Magazine();
            case SCIENCE_MAGAZINE:
                return new ScienceMagazine();
            default:
                throw new IllegalArgumentException("Element doesn't exist! %s");
        }
    }
}
