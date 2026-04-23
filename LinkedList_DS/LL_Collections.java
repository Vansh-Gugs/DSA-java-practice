import java.util.LinkedList;

public class LL_Collections {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("is");
        list.addFirst("This");
        System.out.println(list);

        list.addLast("a"); //by default add is addLast
        list.add("list");
        list.add("yayy");
        System.out.println(list);

        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            // we can add if(list.get(i)==value) for searching operations
            System.out.print(list.get(i)+" -> ");
        }
        System.out.println("NULL");

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove(1); //we can pass index in this
        System.out.println(list);

    }
}
