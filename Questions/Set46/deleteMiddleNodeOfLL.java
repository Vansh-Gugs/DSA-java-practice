class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode deleteMiddle(ListNode head) {

        if(head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while(fast != null && fast.next != null) {

            prev = slow;

            slow = slow.next;

            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}

public class deleteMiddleNodeOfLL {

    // helper function to print linked list
    public static void printList(ListNode head) {

        while(head != null) {
            System.out.print(head.val);

            if(head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        Solution sol = new Solution();

        head = sol.deleteMiddle(head);

        System.out.println("After Deleting Middle:");
        printList(head);

        // second test case
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        System.out.println("\nSecond List:");
        printList(head2);

        head2 = sol.deleteMiddle(head2);

        System.out.println("After Deleting Middle:");
        printList(head2);
    }
}