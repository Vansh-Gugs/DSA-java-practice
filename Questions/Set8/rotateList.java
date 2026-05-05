class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode temp = head;
        int size = 0;
        while(temp!= null) {
            size++;
            temp = temp.next;
        }
        k = k%size;
        if(k==0){
            return head;
        }
        int i=1;
        ListNode dummy = head;
        while(i<(size-k)){
            dummy = dummy.next;
            i++;
        }
        ListNode newHead = dummy.next;
        dummy.next = null;
        ListNode ptr = newHead;
        while(ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = head;
        return newHead;
    }
}

public class rotateList {
     // Create list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {0, 1, 2};
        int k = 4;

        ListNode head = createList(arr);

        System.out.print("Original List: ");
        printList(head);

        ListNode rotated = sol.rotateRight(head, k);

        System.out.print("Rotated List: ");
        printList(rotated);
    }
}
