package com.company;

public interface IStack {
    Object pop();
    Object peek();
    void push(Object element);
    boolean isEmpty();
    int size();
}
