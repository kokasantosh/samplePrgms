package com.sample.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class LeftAndRightViewOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> result = new ArrayList<>();
        leftView(stack, result);
        System.out.println(result);

        result = new ArrayList<>();
        rightView(stack, result);
        System.out.println(result);
    }

    private static void leftView(Stack<TreeNode> stack, List<Integer> elements) {
        elements.add(stack.firstElement().getValue());
        Stack<TreeNode> childStack = new Stack<>();
        for(TreeNode node: stack) {
            if(node.getLeft() != null) {
                childStack.add(node.getLeft());
            }
            if(node.getRight() != null) {
                childStack.add(node.getRight());
            }
        }
        if(! childStack.isEmpty()) {
            leftView(childStack, elements);
        }
    }

    private static void rightView(Stack<TreeNode> stack, List<Integer> elements) {
        elements.add(stack.peek().getValue());
        Stack<TreeNode> childStack = new Stack<>();
        for(TreeNode node: stack) {
            if(node.getLeft() != null) {
                childStack.add(node.getLeft());
            }
            if(node.getRight() != null) {
                childStack.add(node.getRight());
            }
        }
        if(! childStack.isEmpty()) {
            rightView(childStack, elements);
        }
    }
}
