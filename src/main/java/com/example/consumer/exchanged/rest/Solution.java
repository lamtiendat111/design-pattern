package com.example.consumer.exchanged.rest;

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String one = "";
        String two = "";

        do {
            one += l1.val;
            l1 = l1.next;
        } while (l1 != null);


        do {
            two += l2.val;
            l2 = l2.next;
        } while (l2 != null);




        StringBuilder input1 = new StringBuilder(one);
        StringBuilder input2 = new StringBuilder(two);

        input1.reverse();
        input2.reverse();

        long numberOne = Long.parseLong(input1.toString());

        long numberTwo = Integer.parseInt(input2.toString());

        if (one.length() > two.length()) {
            numberTwo *= Math.pow(10, one.length() - two.length());
        } else {
            numberOne *= Math.pow(10, two.length() - one.length());
        }
        String result = String.valueOf(numberOne + numberTwo);
        ListNode head = null;
        if (result.length() > 0) {
            head = new ListNode(Integer.parseInt(String.valueOf(result.charAt(result.length() - 1))));
        }
        ListNode temp = head;

        for (int i = result.length() - 2; i >= 0; i--) {
            ListNode node = new ListNode(Integer.parseInt(String.valueOf(result.charAt(i))));
            temp.next = node;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l2 =
                new ListNode(6,
                    new ListNode(7,
                        new ListNode(8,
                                new ListNode(0,
                                        new ListNode(8,
                                                new ListNode(5,
                                                        new ListNode(8,
                                                                new ListNode(9,
                                                                        new ListNode(7)))))))));
//        ListNode l2 = new ListNode(9,new ListNode(6,new ListNode(4)));
        ListNode l1 =
                new ListNode(0,
                        new ListNode(8,
                                new ListNode(6,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(8,
                                                                new ListNode(3,
                                                                        new ListNode(5,
                                                                                new ListNode(7)))))))));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
