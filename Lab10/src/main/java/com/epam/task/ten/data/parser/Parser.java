package data.parser;
import model.Component;

public interface Parser {
    Component parse(String text);
}
