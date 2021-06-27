package com.sample.tree;

public class TreeHeightFinder {
    public static int height = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));

        //method#1
        calcHeight(root, 1);
        System.out.println("Height of the tree is: " + height);

        //method#2
        System.out.println("Height of the tree is: " + TreeNode.getHeight(root));
    }

    public static void calcHeight(TreeNode node, int level) {
        height = Math.max(height, level);
        if(node.getLeft() != null) {
            calcHeight(node.getLeft(), level + 1);
        }
        if(node.getRight() != null) {
            calcHeight(node.getRight(), level + 1);
        }
    }
}
