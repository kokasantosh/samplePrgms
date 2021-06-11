package com.sample.tree;

import java.util.HashMap;
import java.util.Map;

public class TopAndBottomView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));

        Map<Integer, Integer> map = new HashMap<>();
        topView(root, 0, map);
        System.out.println(map);

        map = new HashMap<>();
        bottomView(root, 0, map);
        System.out.println(map);

    }

    private static void topView(TreeNode node, int nodeValue, Map<Integer, Integer> map) {
        if(! map.containsKey(nodeValue)) {
            map.put(nodeValue, node.getValue());
        }
        if(node.getLeft() != null){
            topView(node.getLeft(), nodeValue - 1, map);
        }
        if(node.getRight() != null){
            topView(node.getRight(), nodeValue + 1, map);
        }
    }

    private static void bottomView(TreeNode node, int nodeValue, Map<Integer, Integer> map) {
        map.put(nodeValue, node.getValue());
        if(node.getLeft() != null){
            bottomView(node.getLeft(), nodeValue - 1, map);
        }
        if(node.getRight() != null){
            bottomView(node.getRight(), nodeValue + 1, map);
        }
    }
}
