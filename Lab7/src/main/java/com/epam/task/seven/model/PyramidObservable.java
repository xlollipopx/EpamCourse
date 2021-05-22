package com.epam.task.seven.model;

import java.util.LinkedList;
import java.util.List;

public class PyramidObservable extends Pyramid implements Observable<PyramidObserver>{
    private List<PyramidObserver> observers = new LinkedList<>();

    public PyramidObservable(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        super(firstPoint, secondPoint, thirdPoint, fourthPoint);

    }

    public PyramidObservable(List<Point> points) {
        super(points);
    }

    @Override
    public void addObserver(PyramidObserver pyramid){
        observers.add(pyramid);
    }

    public void setFirstPoint(Point point){
        super.setFirstPoint(point);
        notifyObservers();
    }

    public void setSecondPoint(Point point){
        super.setSecondPoint(point);
        notifyObservers();
    }

    public void setThirdPoint(Point point){
        super.setThirdPoint(point);
        notifyObservers();
    }

    public void setFourthPoint(Point point){
        super.setFourthPoint(point);
        notifyObservers();
    }

    public void notifyObservers() {
        for(PyramidObserver observer: observers) {
            observer.notify(this);
        }
    }

}