package com.mytest.effectjava;

public interface SetObserver<E> {
    void added(ObservableSet<E> set,E element);
}
