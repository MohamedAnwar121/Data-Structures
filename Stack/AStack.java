package com.company;

import java.util.EmptyStackException;

public class AStack implements IStack{
    private int N = 1000;
    private Object[] stackArr;
    private int top;

    public AStack(){
        top = -1;
        stackArr = new Object[N];
    }

    public AStack(int size){
        top = -1;
        N = size;
        stackArr = new Object[N];
    }

    public Object pop() {
        if (isEmpty()) throw new EmptyStackException();
        else {
            Object element = stackArr[top];
            stackArr[top] = null;
            top--;
            return element;
        }
    }

    public Object peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stackArr[top];
    }

    public void push(Object element){
        if (size() == N) throw new ArrayIndexOutOfBoundsException();
        else{
            top++;
            stackArr[top] = element;
        }
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public int size(){
        return top + 1;
    }

    public void printStack(){
        MyStack temp = new MyStack();
        int realSize = size;

        System.out.print("[");
        for (int i = 0; i < realSize; i++) {
            int out = (int)this.pop();
            temp.push(out);
            System.out.print(out);
            if (i != realSize - 1) System.out.print(", ");
        }
        System.out.print("]");
        System.out.println();

        for (int i = 0; i < realSize; i++) this.push(temp.pop());

    }

}
