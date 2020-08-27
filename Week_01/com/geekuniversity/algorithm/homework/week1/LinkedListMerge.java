package com.geekuniversity.algorithm.homework.week1;

/**
 * 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 解题思路：
 * 1、暴力解法
 * 先将两个链表的值分别放到数组中，在对整个数组进行排序；
 * 接着再把数组中的元素插入链表，时间复杂度较高，Java提供的Array.sorts可以实现；
 * 但是如果要求不允许使用工具类，需要单独写排序算法；
 *
 * 2、双指针
 * 同时遍历两个链表，当其中一个链表的值较小时，放入新的链表，然后值较小的链表访问下一个
 * 依次循环，直到其中一个链表先遍历完
 */
public class LinkedListMerge {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            int val = l1.val < l2.val ? l1.val : l2.val;
            ListNode newNode = new ListNode(val);
            prev.next = newNode;
            prev = prev.next;
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        prev.next = l1 != null ? l1 : l2;
        return head.next;
    }
}

class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}