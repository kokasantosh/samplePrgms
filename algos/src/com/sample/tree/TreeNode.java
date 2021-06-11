package com.sample.tree;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void printBFS() {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        queue.add(this);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.getValue());
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    public void printDFS() {
        if(this.left != null) {
            this.left.printDFS();
        }
        System.out.println(this.value);

        if(this.right != null) {
            this.right.printDFS();
        }
    }

    public void printNodesAtNthLevel(int level) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(this);
        printNodesAtNthLevel(queue, 1, level);
    }

    private void printNodesAtNthLevel(Queue<TreeNode> queue, int currLevel, int targetLevel) {
        Queue<TreeNode> queueToSend = new LinkedBlockingQueue<>();
        for(TreeNode node : queue) {
            if (currLevel == targetLevel) {
                System.out.print(node.value);
            } else if(currLevel < targetLevel) {
                if(node.left != null) {
                    queueToSend.add(node.left);
                }
                if(node.right != null) {
                    queueToSend.add(node.right);
                }
            } else {
                System.out.println("Level provide is not available in the current tree");
            }
        }

        if(!queueToSend.isEmpty()) {
            printNodesAtNthLevel(queueToSend, ++currLevel, targetLevel);
        }
    }

    public static int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
