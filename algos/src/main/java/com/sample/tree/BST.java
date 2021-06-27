package com.sample.tree;

public class BST {


    private TreeNode root;
    public static void main(String[]  args) {
        BST bst = new BST();
        bst.insertNode(4);
        bst.insertNode(6);
        bst.insertNode(2);
        bst.insertNode(1);
        bst.insertNode(3);
        bst.insertNode(5);
        bst.insertNode(7);
        bst.root.printDFS();

    }

    public TreeNode insertNode(int data) {
        return insertNode(root, data);
    }

    public TreeNode getRoot() {
        return root;
    }

    private TreeNode insertNode(TreeNode node, int value) {
        if(node == null) {
            TreeNode nodeTemp = new TreeNode(value);
            if(root == null) {
                root = nodeTemp;
            }
            return nodeTemp;
        }

        if (value == node.getValue()) {
            return node;
        }

        if(value < node.getValue()){
            node.setLeft(insertNode(node.getLeft(), value));
        } else {
            node.setRight(insertNode(node.getRight(), value));
        }

        return node;
    }
}
