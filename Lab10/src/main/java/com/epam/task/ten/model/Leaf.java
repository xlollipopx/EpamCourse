package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leaf implements Component, Cloneable{
    private static final int CHILDREN_AMOUNT = 0;
    private final String word;
    private final LeafType type;

    private Leaf(String word, LeafType type) {
        this.word = word;
        this.type = type;
    }

    public static Leaf createWord(String word) {
        return new Leaf(word, LeafType.WORD);
    }
    public static Leaf createExpression(String word) {
        return new Leaf(word, LeafType.EXPRESSION);
    }

    public ArrayList<Component> getChildren() {
        return new ArrayList<>();
    }

    public int getChildrenSize() {
        return CHILDREN_AMOUNT;
    }

    @Override
    public boolean isExpression() {
        return type.equals(LeafType.EXPRESSION) ;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return Objects.equals(word, leaf.word) &&
                type == leaf.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, type);
    }

    public Leaf clone() throws CloneNotSupportedException {
        Leaf leaf = (Leaf) super.clone();
        return leaf;
    }
}
