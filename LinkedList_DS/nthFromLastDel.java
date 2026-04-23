import java.util.Collections;
import java.util.LinkedList;

public class nthFromLastDel {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println(list);
        Collections.reverse(list);
        list.remove(2-1);
        Collections.reverse(list);
        System.out.println(list);
    }   
}
