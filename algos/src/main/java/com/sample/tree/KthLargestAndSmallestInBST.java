package com.sample.tree;

public class KthLargestAndSmallestInBST {
    static int result;
    static int kthNumber;
    static int currNumber;
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertNode(4);
        bst.insertNode(6);
        bst.insertNode(2);
        bst.insertNode(1);
        bst.insertNode(3);
        bst.insertNode(5);
        bst.insertNode(7);
        kthNumber = 2;
        currNumber = 0;
        result = 0;
        findKthSmallestElement(bst.getRoot());
        System.out.println("kth Smallest number is: " + result);
        currNumber = 2;
        System.out.println(findKthSmallestElement1(bst.getRoot()));

        kthNumber = 2;
        currNumber = 0;
        result = 0;
        findKthLargestElement(bst.getRoot());
        System.out.println("kth Largest number is: " + result);
    }

    private static void findKthSmallestElement(TreeNode node){

        if(node == null || result != 0) {
            return;
        }

        findKthSmallestElement(node.getLeft());
        currNumber ++;
        if(result != 0) {
            return;
        }
        if(kthNumber == currNumber) {
            result = node.getValue();
            return;
        }
        findKthSmallestElement(node.getRight());

        return;
    }

    private static int findKthSmallestElement1(TreeNode node){

        if(node == null) {
            return 0;
        }

        int leftRes = findKthSmallestElement1(node.getLeft());

        if(leftRes != 0) {
            return leftRes;
        }

        currNumber--;

        if(currNumber == 0) {
            return node.getValue();
        }

        int rightRes = findKthSmallestElement1(node.getRight());

        return rightRes;
    }

    private static void findKthLargestElement(TreeNode node){

        if(node == null || result != 0) {
            return;
        }

        findKthSmallestElement(node.getRight());
        currNumber ++;
        if(result != 0) {
            return;
        }
        if(kthNumber == currNumber) {
            result = node.getValue();
            return;
        }
        findKthSmallestElement(node.getLeft());

        return;
    }
}
