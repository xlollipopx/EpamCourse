package logic;

import model.Component;
import model.Composite;

public interface Processor {
    String restore(Component text);
    Component calculate(Component text);
    Component sortParagraphs(Composite text);
    Component sortSentencesByWordLength(Composite text);
}
