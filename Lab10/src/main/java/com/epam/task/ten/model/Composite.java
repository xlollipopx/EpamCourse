package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component, Cloneable {

    private ArrayList<Component> literals;

    public Composite() {
        literals = new ArrayList<Component>();
    }

    public Composite( ArrayList<Component> literals) {
        this.literals = literals;
    }

    public void add(Component component) {
        literals.add(component);
    }

    public ArrayList<Component> getChildren() {
        return literals;
    }

    public int getChildrenSize() {
        return literals.size();
    }

    @Override
    public boolean isExpression() {
        return false;
    }

    @Override
    public String toString() {
        return literals.toString();
    }

    public Composite clone() throws CloneNotSupportedException {
        Composite composite = (Composite)super.clone();
        return composite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(literals, composite.literals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(literals);
    }


}
