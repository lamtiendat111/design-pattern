package com.example.consumer.binarytree;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinaryTree {
    private int value;
    private BinaryTree left;
    private BinaryTree right;
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i =0; i<nums.length ; i++){
            if(map.containsKey(target - nums[i])){
                result[0]=i;
                result[1]= map.get(target - nums[i]);
            }
            map.put(nums[i],i);
        }
        return result;
    }



    public BinaryTree(int i) {
        this.value = i;
    }

    public BinaryTree() {

    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(12);
        root.addNode(20);
        root.addNode(4);
//        root.print();
        System.out.println(root.addNode(1));
        System.out.println(root.addNode(1));

        root.addNode(8);
        root.addNode(16);
        root.addNode(27);
        root.addNode(500);
        System.out.println(root.min());
        System.out.println(root.max());
        ;
//        root.print();
//        System.out.println("search: " + root.search(5));
        ;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public Boolean addNode(int value) {
        return addNode(value, this);
    }

    private Boolean addNode(int value, BinaryTree node) {
        if (value > node.value) {
            if (node.right == null) {
                node.right = new BinaryTree();
                this.initNode(node.right, value);
                return true;
            } else
                return addNode(value, node.right);

        } else if (value < node.value) {
            if (node.left == null) {
                node.left = new BinaryTree();
                this.initNode(node.left, value);
                return true;
            } else
                return addNode(value, node.left);
        }
        return false;
    }

    private void initNode(BinaryTree node, int value) {
        node.value = value;
    }

    public void print() {
        System.out.println("---------------------------");
        System.out.println("node: " + this.value);
        Stack<BinaryTree> queues = new Stack<>();
        queues.add(this.right);
        queues.add(this.left);
        while (!queues.isEmpty()) {
            BinaryTree node = queues.pop();
            if (node != null) {
                System.out.println("node: " + node.value);
                if (node.right != null)
                    queues.add(node.right);
                if (node.left != null)
                    queues.add(node.left);
            }
        }
    }

    public Boolean search(int value) {
        return search(value, this);
    }

    private Boolean search(int value, BinaryTree tree) {
        if (tree == null)
            return false;
        if (value == tree.value) {
            return true;
        } else if (value < tree.value) {
            return search(value, tree.left);
        } else {
            return search(value, this.right);
        }
    }

    public int min() {
        Stack<BinaryTree> stacks = new Stack<>();
        stacks.add(this);
        int min = this.value;
        while (!stacks.isEmpty()) {
            BinaryTree node = stacks.pop();
            if (node != null) {
                if (node.value < min)
                    min = node.value;
                if (node.left != null)
                    stacks.add(node.left);
                else
                    stacks.add(node.right);
            }
        }
        return min;
    }

    public int max() {
        Stack<BinaryTree> stacks = new Stack<>();
        stacks.add(this);
        int max = this.value;
        while (!stacks.isEmpty()) {
            BinaryTree node = stacks.pop();
            if (node != null) {
                if (node.value > max)
                    max = node.value;
                if (node.right != null)
                    stacks.add(node.right);
                else
                    stacks.add(node.left);
            }
        }
        return max;
    }
}
