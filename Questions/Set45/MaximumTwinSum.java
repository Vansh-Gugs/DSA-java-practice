class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    public int pairSum(ListNode head) {

        // first finding middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /* slow is pointing at the last node of the first half,
        we need to reverse the rest, then take the middle pointer
        and the head pointer, sum each and find max from them */

        ListNode currNode = slow.next; // first node of second half
        ListNode prevNode = null;

        while(currNode != null) {

            ListNode nextNode = currNode.next;

            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }

        // prevNode is pointing to the first node of reversed second half

        int max_sum = 0;

        while(prevNode != null) {

            int sum = prevNode.val + head.val;

            prevNode = prevNode.next;
            head = head.next;

            max_sum = Math.max(max_sum, sum);
        }

        return max_sum;
    }
}

public class MaximumTwinSum {

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("Original Linked List:");
        ListNode temp = head;

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();

        Solution sol = new Solution();

        int result = sol.pairSum(head);

        System.out.println("Maximum Twin Sum = " + result);

        // Second test case
        // 5 -> 4 -> 2 -> 1

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);

        int result2 = sol.pairSum(head2);

        System.out.println("Second Test Answer = " + result2);
    }
}
