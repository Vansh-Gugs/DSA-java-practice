import java.util.HashSet;
import java.util.Iterator;

public class hashSetClass {
    public static void main(String[] args) {
        //Creating
        HashSet<Integer> set = new HashSet<>();

        //Insert - add
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //Search - contains
        if(set.contains(1)){
            System.out.println("Set conatins 1");
        }
        if(!set.contains(6)){
            System.out.println("Set does not contain 6");
        }

        //Deletion - remove
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("We deleted 1");
        }

        System.out.println("Size of set is:"+set.size());

        //Print all elements of set
        System.out.println(set);


        //Iterator (cant use for loop to traverse normally)
        Iterator it = set.iterator();
        //hasNext , next
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
