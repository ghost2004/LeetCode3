/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA,
 *  it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */
import java.util.*;
public class RepeatDNASeq {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() <= 10)
            return result;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A',0);
        map.put('C',1);
        map.put('G',2);
        map.put('T',3);
        int i;
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> added = new HashSet<Integer>();
        int hash = 0;
        // get the hash for the first 10 digital
        for (i = 0; i < 10; i++) {
            //each ACGT fit 2 bits, so left shift 2
            hash = (hash <<2) + map.get(s.charAt(i));
        }
        set.add(hash);
        
        for (i = 10; i < s.length();i++) {
            //each ACGT fit 2 bits, so left shift 2
            hash = (hash << 2) + map.get(s.charAt(i));
            // max bit for hash is 2*10 = 20
            hash = hash & (1<<20)-1;
            if (set.contains(hash) && (!added.contains(hash))) {
                result.add(s.substring(i-9, i+1));
                added.add(hash);
            }
            set.add(hash);
        }
         
        
        return result;
    }
    
    
    public static void printArr( List<String> list) {
        for (String a:list) {
            System.out.print(a+"  ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        RepeatDNASeq r = new RepeatDNASeq();
        printArr(r.findRepeatedDnaSequences("GAGAGAGAGAGAG"));
    }
}
