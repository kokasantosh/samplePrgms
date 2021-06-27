package com.sample.linkedlist;

public class LoopIdentifier {
    public static void main(String[] args) {
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
        linkedListNode6.setNext(linkedListNode3);
        System.out.println("Is Loop Present: " + isLoopExists(linkedListNode1));
    }

    private static boolean isLoopExists(LinkedListNode root) {
        boolean isLoop = false;
        LinkedListNode slow = root;
        LinkedListNode fast = root;

        while (fast != null && fast.next() != null) {
            slow = slow.next();
            fast = fast.next().next();
            if (slow == fast) {
                isLoop = true;
                break;
            }
        }
        return isLoop;
    }
}
