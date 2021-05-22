package logic;

import logic.expression.calculator.ExpressionCalculator;
import model.Component;
import model.Composite;
import model.Leaf;

import java.util.ArrayList;
import java.util.Comparator;

public class CompositeProcessor implements Processor {

    @Override
    public String restore(Component text) {
        StringBuilder result = new StringBuilder();
        if(text.getChildrenSize() == 0) {
            result.append(text.toString() + " ");
        }
        for(int i = 0; i < text.getChildrenSize(); i++) {
                String line = restore(text.getChildren().get(i));
                result.append(line);
        }
        return result.toString();
    }

    @Override
    public Component calculate(Component text) {
        Composite composite = new Composite();
        if(text.isExpression()) {
            ExpressionCalculator calculator = new ExpressionCalculator(text.toString());
            Number number = calculator.calculate();
            String result = number.toString();
            Leaf leaf = Leaf.createExpression(result);
            composite.add(leaf);
        } else if(text.getChildrenSize() == 0){
            Leaf leaf = Leaf.createWord(text.toString());
            composite.add(leaf);
        }

        for(Component component: text.getChildren()) {
                composite.add(calculate(component));
        }
        return composite;
    }

    @Override
    public Component sortParagraphs(Composite text) {
        Component textCopy = null;
        try {
             textCopy = text.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        ArrayList<Component> paragraphs = textCopy.getChildren();
        paragraphs.sort(Comparator.comparingInt(Component::getChildrenSize));
        Composite newComposite = new Composite(paragraphs);
        return newComposite;
    }

    @Override
    public Component sortSentencesByWordLength(Composite text) {
        Component textCopy = null;
        try {
            textCopy = text.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        ArrayList<Component> paragraphs = textCopy.getChildren();
        for(Component paragraph: paragraphs) {
            for (Component sentence : paragraph.getChildren()) {
                ArrayList<Component> words = sentence.getChildren();
                words.sort((cmpOne, cmpTwo) -> {
                    String lOne = cmpOne.toString();
                    String lTwo = cmpTwo.toString();
                    return lOne.length() - lTwo.length();
                });
            }
        }
        Composite newComposite = new Composite(paragraphs);
        return newComposite;
    }

}
