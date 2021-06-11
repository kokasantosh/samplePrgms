package com.sample.tree;

import java.util.ArrayList;

public class LeastCommonAncestor {

    static boolean pathFound = false;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));

        System.out.println(calcLeastCommonAncestor(root.getLeft().getLeft(), root.getLeft().getRight(), root));
    }

    private static Integer calcLeastCommonAncestor(TreeNode node1, TreeNode node2, TreeNode root) {
        String result = null;
        ArrayList<Integer> path1 = new ArrayList<>();
        findPath(node1, root, path1);
        ArrayList<Integer> path2 = new ArrayList<>();
        pathFound = false;
        findPath(node2, root, path2);
        int index = 0;
        for(int i = 0; i < path1.size(); i ++) {
            if(path1.get(i) != path2.get(i)) {
               index = i - 1;
               break;
            }
        }

        return path1.get(index);
    }

    private static void findPath(TreeNode node, TreeNode curr, ArrayList<Integer> path) {
        path.add(curr.getValue());

        if (curr == node) {
            pathFound = true;
            return;
        }

        if(!pathFound && curr.getLeft() != null) {
            findPath(node, curr.getLeft(), path);
        }
        if(!pathFound && curr.getRight() != null) {
            findPath(node, curr.getRight(), path);
        }
        if(!pathFound) {
            path.remove(path.size() - 1);
        }
    }

}
