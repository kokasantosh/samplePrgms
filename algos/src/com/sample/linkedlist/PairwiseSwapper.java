package com.sample.linkedlist;

public class PairwiseSwapper {
    public static void main(String[] args){
        LinkedListNode<String> linkedListNode1 = new LinkedListNode("1");
        LinkedListNode<String> linkedListNode2 = new LinkedListNode("2");
        LinkedListNode<String> linkedListNode3 = new LinkedListNode("3");
        LinkedListNode<String> linkedListNode4 = new LinkedListNode("4");
        LinkedListNode<String> linkedListNode5 = new LinkedListNode("5");
        LinkedListNode<String> linkedListNode6 = new LinkedListNode("6");
        linkedListNode1.setNext(linkedListNode2);
        linkedListNode2.setNext(linkedListNode3);
        linkedListNode3.setNext(linkedListNode4);
        linkedListNode4.setNext(linkedListNode5);
        linkedListNode5.setNext(linkedListNode6);
        LinkedListNode root = pairwiseSwap(linkedListNode1);
        root.print();
    }

    private static LinkedListNode pairwiseSwap(LinkedListNode root) {
        LinkedListNode rootNode = root;
        LinkedListNode curr = root;
        LinkedListNode next = root.next();
        LinkedListNode prev = null;
        while(curr != null && next != null) {
            if(prev != null) {
                prev.setNext(next);
            } else {
                rootNode = next;
            }
            LinkedListNode temp = next.next();
            next.setNext(curr);
            curr.setNext(temp);
            prev = curr;
            curr = temp;
            if(curr != null)
                next = curr.next();
        }

        return rootNode;
    }
}
