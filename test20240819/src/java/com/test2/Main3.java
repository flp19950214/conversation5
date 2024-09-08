package com.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        method();
    }

    static int target = 22;
    static List<List<Integer>> res = new ArrayList<>();

    public static void method() {
        /**
         *      5
         *    4     8
         *  11    13   4
         *7   2       5 1
         */
        Node node = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(8);
        Node node4 = new Node(11);
        Node node41 = new Node(13);
        Node node5 = new Node(4);
        Node node6 = new Node(7);
        Node node7 = new Node(2);
        Node node8 = new Node(5);
        Node node9 = new Node(1);
        node5.left = node8;
        node5.right = node9;
        node3.left = node41;
        node3.right = node5;
        node.right = node3;

        node4.right = node7;
        node4.left = node6;
        node2.left = node4;
        node.left = node2;

        method2(node, new ArrayList<>());
        List<List<Integer>> collect = res.stream()
                .filter(m -> m.stream().reduce((a, b) -> a + b).get() == target)
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public static void method2(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            if (node.left == null && node.right == null) {
                res.add(list);
                return;
            }
            List<Integer> listl = list.stream().collect(Collectors.toList());
            List<Integer> listr = list.stream().collect(Collectors.toList());
            method2(node.left, listl);
            method2(node.right, listr);
        }
    }

}
