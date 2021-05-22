package model;

import java.util.ArrayList;
import java.util.List;

public interface Component{
    ArrayList<Component> getChildren();
    int getChildrenSize();
    boolean isExpression();
}

