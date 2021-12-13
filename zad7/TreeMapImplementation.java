import java.util.*; 
import java.util.concurrent.*; 
  
public class TreeMapImplementation { 
  
    // Function to show TreeMap() constructor example 
    static void Example1stConstructor() 
    { 
        // Creating an empty TreeMap 
        TreeMap<Integer, String> tree_map 
            = new TreeMap<Integer, String>(); 
  
        // Mapping string values to int keys 
        tree_map.put(10, "Geeks"); 
        tree_map.put(15, "4"); 
        tree_map.put(20, "Geeks"); 
        tree_map.put(25, "Welcomes"); 
        tree_map.put(30, "You"); 
  
        // Displaying the TreeMap 
        System.out.println("TreeMap: "
                           + tree_map); 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
  
        System.out.println("TreeMap using "
                           + "TreeMap() constructor:\n"); 
        Example1stConstructor(); 
    } 
} 