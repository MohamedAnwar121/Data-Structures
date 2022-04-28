package com.company;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class LinkedListQueue<T> implements IQueue<T>{
    static Scanner scan = new Scanner(System.in);

    private class QNode {
        private T element;
        private QNode next;

        QNode(T element, QNode next) {
            this.element = element;
            this.next = next;
        }
    }

    private int size;
    private QNode head, tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T item) {
        QNode node = new QNode(item,null);
        if(size == 0)
            head = node;
        else
            tail.next = node;
        tail = node;
        size++;
    }

    public T dequeue() {
        T element = head.element;
        if (size == 0) throw new RuntimeException();
        else head = head.next;
        size--;
        if(size == 0) tail = null;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString(){
        int tempSize = this.size();
        T [] arr = (T[]) new Object[tempSize];
        for (int i = 0; i < tempSize; i++) {
            T temp = this.dequeue();
            arr[tempSize - i - 1] = temp;
            this.enqueue(temp);
        }

        String queue = "";
        queue += "[";
        for (int i = 0; i < tempSize; i++) {
            queue += arr[i];
            if (i != tempSize - 1) queue += ", ";
        }
        queue += "]";
        return queue;
    }
}
