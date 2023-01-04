//*********************************************************************************************************************************************************************************************************************
// HashTableTest.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 5 - Question 3 HashTable with Book codes
// HashTableTest.java - The program is the test the functionality of HashTable.java   
// All methods from HashTable.java have been used.
////*****************************************************************************************************************************************************************************************

public class HashTableTest
{
    public static void main(String [] args)
    {
        // create new hash table with size of 11 and load factor of 70% 
        HashTable hashtable = new HashTable();
    
        // we let book 1,2,3 to be have same last 3 digits - "99-9" 
        // also, allow book 7,8,9 to have same last 3 digits- "00-0"\
                            
        String [] keys1 = {"6-24-193399-9","0-23-193399-9","0-65-293399-9","0-65-493346-9",
                            "0-65-544332-0","0-65-632343-0","0-65-325300-0","0-65-743300-0"};
                                              
        // we give keys its values(element).
        String [] values1 = {"Book 1", "Book 2", "Book 3", "Book 4", "Book 5", "Book 6",
                             "Book 7", "Book 8"};
        
        // create extra keys to expand table size
        String [] keys2 = {"0-65-982400-0", "0-65-341343-0"};
        // we give keys its values(element)
        String [] values2 = {"Book 9", "Book 10"};
                
        // Add 8 books to hash table
        for (int i = 0; i < keys1.length; i++)
            hashtable.put(keys1[i], values1[i]);
        
        // return whole hash table 
        System.out.println(hashtable);
        // return current size
        System.out.println("current size ? " + hashtable.capacity());
        // return number of values, note its only marked no delete.
        System.out.println("contain items ? " +  hashtable.getNumberOfValues()); 
        // Returns the number of values marked as deleted in the hash table
        System.out.println("cell marked with deleted ? " +  hashtable.getDeletedValues()); 
        // return total books in hash
        System.out.println("current size in table? " +  hashtable.size()+"\n"); 

        // add 2 more books to hash table
        for (int i = 0; i < keys2.length; i++)
            hashtable.put(keys2[i], values2[i]);
            
        // return whole hash table 
        System.out.println(hashtable);
        // return current size
        System.out.println("current size ? " + hashtable.capacity());
        // return number of values, note its only marked no delete.
        System.out.println("contain items ? " +  hashtable.getNumberOfValues()); 
        // Returns the number of values marked as deleted in the hash table
        System.out.println("cell marked with deleted ? " +  hashtable.getDeletedValues()); 
        // return total books in hash
        System.out.println("current size in table? " +  hashtable.size()+"\n"); 

        // clear out the table 
        hashtable.clear();
        // check if table is empty
        hashtable.isEmpty();
        
        // add the extra 2 books first, then add the remaining 8 books
        for (int i = 0; i < keys2.length; i++)
            hashtable.put(keys2[i], values2[i]);  
        for (int i = 0; i < keys1.length; i++)
            hashtable.put(keys1[i], values1[i]);
        
        // return whole hash table 
        System.out.println(hashtable);
        // return current size
        System.out.println("current size ? " + hashtable.capacity());
        // return number of values, note its only marked no delete.
        System.out.println("contain items ? " +  hashtable.getNumberOfValues()); 
        // Returns the number of values marked as deleted in the hash table
        System.out.println("cell marked with deleted ? " +  hashtable.getDeletedValues()); 
        // return total books in hash
        System.out.println("current size in table? " +  hashtable.size()+"\n"); 

        // test for searching keys and values
        
        // search for a exist key 
        System.out.println(hashtable.containsKey("0-65-544332-0"));
        // search for a non-exist key 
        System.out.println(hashtable.containsKey("0-65-549332-0"));
        
        // search for a exist value 
        System.out.println(hashtable.containsValue("Book 2"));
        //  search for a non-exist value
        System.out.println(hashtable.containsValue("Book 999"));
        
        // search value for a exist key
        System.out.println(hashtable.getValue("0-65-544332-0")+"\n");
    
        // remove three items with same last 3 digits from the hash table
        hashtable.remove("0-65-743300-0");
        hashtable.remove("0-65-982400-0");
        hashtable.remove("0-65-341343-0");
        
        // return whole hash table 
        System.out.println(hashtable);
        // return current size
        System.out.println("current size ? " + hashtable.capacity());
        // return number of values, note its only marked no delete.
        System.out.println("contain items ? " +  hashtable.getNumberOfValues()); 
        // Returns the number of values marked as deleted in the hash table
        System.out.println("cell marked with deleted ? " +  hashtable.getDeletedValues()); 
        // return total books in hash
        System.out.println("current size in table? " +  hashtable.size()+"\n"); 

        
        // remove 2 books from table by key
        hashtable.remove("6-24-193399-9");
        hashtable.remove("0-23-193399-9");
    
        // return whole hash table 
        System.out.println(hashtable);
        // return current size
        System.out.println("current size ? " + hashtable.capacity());
        // return number of values, note its only marked no delete.
        System.out.println("contain items ? " +  hashtable.getNumberOfValues()); 
        // Returns the number of values marked as deleted in the hash table
        System.out.println("cell marked with deleted ? " +  hashtable.getDeletedValues()); 
        // return total books in hash
        System.out.println("current size in table? " +  hashtable.size()+"\n"); 
    }
} // end 
