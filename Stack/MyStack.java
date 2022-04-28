package com.company;

import java.util.EmptyStackException;
import java.util.Scanner;

public class MyStack implements IStack {
     static Scanner scan = new Scanner(System.in);
     private static class SNode {
        private Object element;
        private SNode next;

        SNode(Object element) {
            this.element = element;
        }
    }

    private SNode top;
    private int size;

    public MyStack(){
        top = null;
        size = 0;
    }

    public Object pop() {
        if (isEmpty()) throw new EmptyStackException();
        else {
            SNode q = top;
            top =  top.next;
            size--;
            return q.element;
        }
    }

    public Object peek() {
        if (isEmpty()) throw new EmptyStackException();
        else return top.element;
    }

    public void push(Object element){
        SNode node = new SNode(element);
        node.next = top;
        top = node;
        size++;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public int size(){
        return size;
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
