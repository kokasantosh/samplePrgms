package com.sample.tree;

import java.util.*;

public class AllRootToLeafPaths {
//    private static Map<Integer, List<Integer>> paths = new HashMap<>();
    private static int key = 1;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        printPaths(root, new ArrayList<>());
    }

    private static void printPaths(TreeNode node, ArrayList<Integer> parentPath) {
        if(node == null) {
            return;
        }

        ArrayList<Integer> currPath = new ArrayList<>(parentPath);

        currPath.add(node.getValue());


        if(node.getLeft() != null) {
            printPaths(node.getLeft(), currPath);
        }

        if(node.getRight() != null) {
            printPaths(node.getRight(), currPath);
        }

        if(node.getLeft() == null && node.getRight() == null) {
            System.out.println(currPath);
        }


    }

}
