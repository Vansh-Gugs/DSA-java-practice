
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }
            else if(list2.val<=list1.val){
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        while(list1!=null){
            ListNode add = new ListNode(list1.val);
            head.next = add;
            head = head.next;
            list1 = list1.next;
        }
        while(list2!=null){
            ListNode add = new ListNode(list2.val);
            head.next = add;
            head = head.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}
public class mergeSortedLists {
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};

        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        ListNode merged = sol.mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);
    }
}
