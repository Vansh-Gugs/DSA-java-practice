
// Access is O(n)
// Insert is O(1), as we just need to change pointers, but finding index takes O(n)

public class basics {

    Node head;
    private int size; // so we dont need to traverse whole list for size later

    // we'll make constructor for size to initialize
    basics(){
        this.size = 0;
    }

    class Node{
        String data;
        Node next;
        // constructor, this will happen whenever new object with Node(data) is called
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // add :- first
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        //else part
        newNode.next = head;
        head = newNode;
    }
    // add:- last
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next= newNode;
    }

    //print list
    public void printList(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    //delete first
    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head = head.next; // the first node will be lost and will be automatically deleted by java garbage collector
        size--;
    }

    //delete last
    public void deleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next==null){
            head = null;
            return;
        }
        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }
        //currNode is the second last node now
        currNode.next=null;
    }

    public int getSize(){
        return size;
    }


    public void reverseIterative(){
        if(head==null || head.next == null){
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursive(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        basics list = new basics();
        // list.addFirst("a");
        // list.addFirst("is");
        // list.printList();
        // list.addLast("list");
        // list.addFirst("This");
        // list.printList();

        // list.deleteFirst();
        // list.printList();
        // list.deleteLast();
        // list.printList();

        // System.out.println(list.getSize());

        // list.deleteLast();
        // list.printList();
        // System.out.println(list.getSize());

        // list.deleteLast();
        // list.printList();
        // System.out.println(list.getSize());

        list.addFirst("Hello");
        list.addFirst("My");
        list.addFirst("Name");
        list.addFirst("is");
        list.addFirst("Vansh");
        list.addFirst("Gugliani");
        list.printList();

        // list.reverseIterative();
        // list.printList();
        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}
