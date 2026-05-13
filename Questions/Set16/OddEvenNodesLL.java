class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode();
        ListNode dummyEven = new ListNode();
        ListNode tempOdd = dummyOdd;
        ListNode tempEven = dummyEven;
        int i=1;
        while(head!=null){
            if(i%2!=0){
                tempOdd.next = head;
                tempOdd = tempOdd.next;
            }
            else{
                tempEven.next = head;
                tempEven = tempEven.next;
            }
            head = head.next;
            i++;
        }
        tempEven.next = null;
        tempOdd.next = dummyEven.next;
        ListNode newHead = new ListNode();
        newHead = dummyOdd.next;
        return newHead;
    }
}


public class OddEvenNodesLL {
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    // Helper to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {1, 2, 3, 4, 5};

        ListNode head = createList(arr);

        System.out.print("Original List: ");
        printList(head);

        ListNode result = sol.oddEvenList(head);

        System.out.print("Odd-Even Rearranged List: ");
        printList(result);
    }
}
