package com.sample.tree;

public class MirrorTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.printBFS();
        mirrorTree(root);
        root.printBFS();
    }
    private static void mirrorTree(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
        mirrorTree(node.getLeft());
        mirrorTree(node.getRight());
    }
}
