package Challange2;

import java.beans.PropertyEditorManager;
import java.util.List;

//Challange link : https://leetcode.com/problems/add-two-numbers/
/*
 *   Given:
 *           2 non-empty linked list
 *   Result:
 *           add two numbers and return the sum as a linked list
 *   Example:
 *           l1 = [ 2  4   3 ] = 342
 *           l2 = [ 5  6   4 ] = 465
 *           l3 [ 7 0 8 ] = 7 0 8
 *
 * */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode firstNode = null;
        boolean isFirst = true;
        int remaining = 0;
        int sumResult;
        while (true) {
            if(isFirst){
                firstNode = result;
                isFirst = false;
            }
            if (l1 == null && l2 == null) {
                if (remaining > 0) {
                    result.next = new ListNode(remaining);
                }
                break;
            }
            ListNode next;
            sumResult = sum(l1, l2, remaining);
            remaining = checkIfMoreThanTenReturnOne(sumResult);
            result.val = returnSingleDigitLessThan10(sumResult);
            l1 = getNextNodeIfExist(l1);
            l2 = getNextNodeIfExist(l2);
            if(l1 != null || l2 != null){
                next = new ListNode();
                result.next = next;
                result = next;
            }
        }
        return firstNode;
    }

    public ListNode getNextNodeIfExist(ListNode currentListNode){
        return currentListNode == null?null:currentListNode.next;
    }
    private int returnSingleDigitLessThan10(int sumResult) {
        return sumResult >= 10 ? sumResult % 10 : sumResult;
    }

    private int checkIfMoreThanTenReturnOne(int result) {
        return result >= 10 ? 1 : 0;
    }

    private int sum(ListNode l1, ListNode l2, int remaining) {
        return (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + remaining;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }
}
