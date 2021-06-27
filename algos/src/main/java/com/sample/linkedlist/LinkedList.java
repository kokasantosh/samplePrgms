package com.sample.linkedlist;

public class LinkedList<T> {
    private Node head = null;
    private int length = 0;
    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    public void insertAtIndex(int index, T value) {
        if(index >= 0) {
            if(index == 0) {
                Node node = new Node(value);
                node.next = head;
                head = node;
            } else {
                int currIndex = 1;
                Node curr = head;
                while (currIndex < index) {
                    curr = curr.next;
                    currIndex ++;
                }
                Node node = new Node(value);
                node.next = curr.next;
                curr.next = node;
            }
            length ++;
        }else {
            System.out.println("Provided wrong index: " + index);
        }
    }

    public void removeAtIndex(int index) {
        if(index >= 0 && index < length) {
            if(index == 0) {
                head = head.next;
            } else {
                int currIndex = 1;
                Node curr = head;
                while (currIndex < index) {
                    curr = curr.next;
                    currIndex ++;
                }
                Node temp = curr.next;
                curr.next = null;
                curr.next = temp.next;
            }
            length --;
        } else {
            System.out.println("Provided wrong index: " + index);
        }
    }

    public void push(T value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        length ++;
    }

    public Node pop() {
        Node removedNode = head;
        if(head != null) {
            head = head.next;
            length --;
        }else {
            System.out.println("No Item to pop");
        }
        return removedNode;
    }

    public int size() {
        return length;
    }
    public void print() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public void pairwiseSwap() {
        if(head == null) {
            return;
        }

        Node prev = null;
        Node one = head;
        Node two = head.next;

        while(one != null && two != null) {
            if(prev != null) {
                prev.next = two;
            } else {
                head = two;
            }
            one.next = two.next;
            two.next = one;

            prev = one;
            one = one.next;
            two = null;

            if(one != null) {
                two = one.next;
            }

        }
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
    }

    public Node getMiddleNode() {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isLoopExists() {
        boolean isLoop = false;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isLoop = true;
                break;
            }
        }

        return isLoop;
    }
}

