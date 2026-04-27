import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class hashMapClass {
    public static void main(String[] args) {
        // Country population
        HashMap<String,Integer> map = new HashMap<>();
        
        //Insertion - put
        map.put("India",120);
        map.put("USA",30);
        map.put("China",150);

        System.out.println(map); // Unordered
        
        //Update
        map.put("China",180);
        System.out.println(map);

        // Search
        if(map.containsKey("China")){
            System.out.println("Key present in map");
        }
        else{
            System.out.println("Key is not present in map");
        }
        System.out.println(map.get("China")); //key exists
        System.out.println(map.get("Taiwan")); //key doesnt exist

        // Iteration
        for(Map.Entry<String,Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }  
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + ":" + map.get(key));
        }

        //Remove 
        map.remove("China");
        System.out.println(map);
    }
}
