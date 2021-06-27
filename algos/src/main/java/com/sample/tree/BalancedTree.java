package com.sample.tree;

public class BalancedTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));


        System.out.println("Is Balanced Tree: " + isBalanced(root));
    }

    private static boolean isBalanced(TreeNode node) {

        if(node == null || (Math.abs(TreeNode.getHeight(node.getLeft()) - TreeNode.getHeight(node.getRight())) <= 1
                && isBalanced(node.getLeft()) && isBalanced(node.getRight()))) {
            return true;
        }

        return false;
    }
}
