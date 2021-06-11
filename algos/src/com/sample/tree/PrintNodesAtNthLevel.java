package com.sample.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrintNodesAtNthLevel {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertNode(4);
        bst.insertNode(6);
        bst.insertNode(2);
        bst.insertNode(1);
        bst.insertNode(3);
        bst.insertNode(5);
        bst.insertNode(7);
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(bst.getRoot());
        printNodesAtNthLevel(queue, 1, 3);
    }

    private static void printNodesAtNthLevel(Queue<TreeNode> queue, int currLevel, int targetLevel) {
        if(currLevel == targetLevel) {
            for(TreeNode node: queue) {
                System.out.println(node.getValue());
            }
            return;
        }
        Queue newQueue = new LinkedBlockingQueue();
        for(TreeNode node: queue) {
            if(node.getLeft() != null) {
                newQueue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                newQueue.add(node.getRight());
            }
        }
        if(!newQueue.isEmpty()) {
            printNodesAtNthLevel(newQueue, ++currLevel, targetLevel);
        }
    }

}
