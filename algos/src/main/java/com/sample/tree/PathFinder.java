package com.sample.tree;

import java.util.ArrayList;

public class PathFinder {
    private static ArrayList<Integer> path = new ArrayList<>();
    private static boolean isPathFound = false;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        getPath(root, 6, true);
        System.out.println(path);
    }

    private static void getPath(TreeNode currNode, int targetNodeVal, boolean isRoot) {
            if (isRoot) {
                path = new ArrayList<>();
                isPathFound = false;
            }
            path.add(currNode.getValue());
            if (targetNodeVal == currNode.getValue()) {
                isPathFound = true;
                return;
            }

            if (!isPathFound && currNode.getLeft() != null) {
                getPath(currNode.getLeft(), targetNodeVal, false);
            }
            if (!isPathFound && currNode.getRight() != null) {
                getPath(currNode.getRight(), targetNodeVal, false);
            }

            if (!isPathFound) {
                path.remove(path.indexOf(currNode.getValue()));
            }

    }

}
