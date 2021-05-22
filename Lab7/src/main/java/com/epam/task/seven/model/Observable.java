package com.epam.task.seven.model;

public interface Observable<T> {
   void addObserver(T pyramid);
   void notifyObservers();
}
