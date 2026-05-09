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
// import java.math.BigInteger;
class Solution {

    // Not the right approach, there is an optimised approach that does not use BigInteger
    // public ListNode reverseList(ListNode head){
    //     if(head == null || head.next == null) return head;
    //     ListNode prevNode = null;
    //     ListNode currNode = head;
    //     while(currNode != null){
    //         ListNode nextNode = currNode.next;
    //         currNode.next = prevNode;

    //         prevNode = currNode;
    //         currNode = nextNode;
    //     }
    //     head = prevNode;
    //     return head;
    // }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 = reverseList(l1);
        // l2 = reverseList(l2);
        // BigInteger num1 = BigInteger.ZERO;
        // BigInteger num2 = BigInteger.ZERO;
        // while(l1!=null){
        //     num1 = num1.multiply(BigInteger.TEN).add(BigInteger.valueOf(l1.val));
        //     l1 = l1.next;
        // }
        // while(l2!=null){
        //     num2 = num2.multiply(BigInteger.TEN).add(BigInteger.valueOf(l2.val));
        //     l2 = l2.next;
        // }
        // BigInteger sum = num1.add(num2);
        // if(sum.equals(BigInteger.ZERO)) return new ListNode(0);
        // ListNode dummy = new ListNode(0);
        // ListNode head = dummy;
        // while(!sum.equals(BigInteger.ZERO)){
        //     int digit = sum.mod(BigInteger.TEN).intValue();
        //     ListNode newNode = new ListNode(digit);
        //     dummy.next = newNode;
        //     dummy = newNode;
        //     sum = sum.divide(BigInteger.TEN);
        // }
        // return head.next;


        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int sum = carry;
            if(l1!=null){
                sum = sum + l1.val;
                l1= l1.next;
            }
            if(l2!=null){
                sum = sum+l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            int digit = sum%10;
            ListNode temp = new ListNode(digit);
            curr.next = temp;
            curr = temp;
        }
        return dummy.next;  //as dummy points to 0, the actual list starts after that
    }
}
public class addTwoNumsList {
    // Helper to create linked list from array
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

        int[] arr1 = {2, 4, 3}; // represents 342
        int[] arr2 = {5, 6, 4}; // represents 465

        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.print("Sum List: ");
        printList(result);
    }
}
