package data.parser;

import model.Component;
import model.Composite;

public abstract class AbstractParser implements Parser {
    private Parser successor;

    protected Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser parser) {
        successor = parser;
    }

    public Component parse(String text) {
        Composite component = new Composite();
        for(String line : text.split(getRegex())) {
            Parser successor = getSuccessor();
            Component child = successor.parse(line);
            component.add(child);
        }
        return component;
    }

    protected abstract String getRegex();

}
