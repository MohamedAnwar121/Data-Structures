import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DoubleLinkedList implements ILinkedList{
    static class DLNode {
        private Object element;
        private DLNode next, prev;

        DLNode(Object element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private DLNode head;
    private DLNode tail;
    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        long size = 0;
    }

    public void add(int index, Object element) {
        DLNode q = head;
        DLNode p;
        DLNode node = new DLNode(element);

        if (index >= this.size() || index < 0) throw new IndexOutOfBoundsException();
        else {
            if (index == 0) {
                node.next = head;
                head = node;
            } else {
                for (int i = 0; i < index - 1; i++) q = q.next;
                p = q.next;
                node.next = p;
                node.prev = q;
                p.prev = node;
                q.next = node;
            }
            size++;
        }
    }


    public void add(Object element) {
        DLNode node = new DLNode(element);
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }
    }


    public Object get(int index) {
        DLNode q = head;
        if (index >= this.size || index < 0) throw new IndexOutOfBoundsException();
        else for (int i = 0; i < index; i++) q = q.next;
        return q.element;
    }


    public void set(int index, Object element) {
        DLNode q = head;
        if (index >= this.size || index < 0) throw new IndexOutOfBoundsException();
        else {
            for (int i = 0; i < index; i++) q = q.next;
            q.element = element;
        }
    }


    public void clear() {
        head = null;
        size = 0;
    }


    public boolean isEmpty() {
        return head == null;
    }


    public void remove(int index) {
        DLNode q = head;
        DLNode p;
        DLNode n;
        if (index >= this.size || index < 0) throw new IndexOutOfBoundsException();
        else {
            if (index == 0) {
                head = head.next;
                head.prev = null;
            }
            else {
                for (int i = 0; i < index - 1; i++) q = q.next;
                p = q.next;
                if(p.next == null){
                    q.next = p.next;
                    p.prev = null;
                }
                else{
                    n = p.next;
                    q.next = n;
                    n.prev = q;
                    p.next = null;
                    p.prev = null;
                }
            }
            size--;
        }
    }


    public int size() {
        return size;
    }


    public ILinkedList sublist(int fromIndex, int toIndex) {
        DoubleLinkedList list = new DoubleLinkedList();
        DLNode q = head;
        if (fromIndex >= this.size || toIndex >= this.size || fromIndex < 0 || toIndex < 0|| fromIndex > toIndex ) throw new IndexOutOfBoundsException();
        for (int i = 0; i < fromIndex; i++) q = q.next;
        for (int i = fromIndex; i <= toIndex; i++) {
            list.add(q.element);
            q = q.next;
        }
        return list;
    }

    @Override
    public boolean contains(Object o) {
        DLNode q = head;
        for (int i = 0; i < this.size; i++) {
            if (q.element.equals(o)) return true;
            q = q.next;
        }
        return false;
    }

    public void printLinkedList() {
        System.out.print("[");
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.get(i));
            if (i != this.size - 1) System.out.print(", ");
        }
        System.out.print("]");
    }
}