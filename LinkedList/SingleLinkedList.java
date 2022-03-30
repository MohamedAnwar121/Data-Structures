import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SingleLinkedList implements ILinkedList {
    static class SLNode {
        private Object element;
        private SLNode next;

        SLNode(Object element) {this.element = element;}
    }

    private SLNode head;
    private SLNode tail;
    private int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
        long size = 0;
    }

    public void add(int index, Object element) {
        SLNode q = head;
        SLNode node = new SLNode(element);

        if (index >= this.size() || index < 0) throw new IndexOutOfBoundsException();
        else {
            if(index == 0) {
                node.next = head;
                head = node;
            }
            else {
                for (int i = 0; i < index - 1; i++) q = q.next;
                node.next = q.next;
                q.next = node;
            }
            size++;
        }
    }

    public void add(Object element) {
        SLNode node = new SLNode(element);
        node.next = null;
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public Object get(int index) {
        SLNode q = head;
        if (index >= this.size || index < 0) throw new IndexOutOfBoundsException();
        else for (int i = 0; i < index; i++) q = q.next;
        return q.element;
    }

    public void set(int index, Object element) {
        SLNode q = head;
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
        SLNode q = head;
        SLNode p;
        if (index >= this.size || index < 0) throw new IndexOutOfBoundsException();
        else {
            if (index == 0) head = head.next;
            else {
                for (int i = 0; i < index - 1; i++) q = q.next;
                p = q.next;
                q.next = p.next;
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

    public ILinkedList sublist(int fromIndex, int toIndex) {
        SingleLinkedList list = new SingleLinkedList();
        SLNode q = head;
        if (fromIndex >= this.size || toIndex >= this.size || fromIndex < 0 || toIndex < 0|| fromIndex > toIndex ) throw new IndexOutOfBoundsException();
        for (int i = 0; i < fromIndex; i++) q = q.next;
        for (int i = fromIndex; i <= toIndex; i++) {
            list.add(q.element);
            q = q.next;
        }
        return list;
    }

    public boolean contains(Object o) {
        SLNode q = head;
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

