package com.sample.linkedlist;

public class LinkedListNode<T> {
    T value;
    LinkedListNode next;

    public LinkedListNode(T value) {
        this.value = value;
        next = null;
    }

    public LinkedListNode next() {
        return next;
    }

    public void setNext(LinkedListNode node) {
        this.next = node;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print() {
        LinkedListNode curr = this;
        while(curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }
}
