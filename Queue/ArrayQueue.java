package com.company;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements IQueue<T>{
    static Scanner scan = new Scanner(System.in);
    private T[] Q;
    private final int N = 1000;
    private int f = 0, r = 0;

    public ArrayQueue(){
        Q = (T[]) new Object[N];
    }

    public ArrayQueue(Class<T> temp, int cap) {
        Q = (T[]) new Object[cap];
    }

    public void enqueue(T item) {
        if (size() == N - 1) throw new ArrayIndexOutOfBoundsException();
        else{
            Q[r] = item;
            r = (r + 1 ) % N;
        }
    }

    public T dequeue() {
        if(isEmpty()) throw new RuntimeException();
        else {
            T dequeue = Q[f];
            Q[f] = null;
            f = (f + 1) % N;
            return dequeue;
        }
    }

    public boolean isEmpty() {
        return f == r;
    }

    public int size() {
        return (N - f + r) % N;
    }

    @Override
    public String toString(){
        String queue = "";
        queue += "[";

        int l = f, u = r;
        if(f > r) {
            l = r;
            u = f;
        }
        for (int i = r - 1; i >= f; i--) {
            queue += Q[i];
            if (i != f) queue += ", ";
        }
        queue += "]";
        return queue;
    }
}
