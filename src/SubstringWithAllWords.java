/*
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word 
 * in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */
import java.util.*;
public class SubstringWithAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> out = new  ArrayList<Integer>();
        if (S == null || S.length() == 0 || L == null || L.length == 0)
            return out;
        
        int num = L.length;
        int len = L[0].length();
        int length =  S.length();
        int min = num * len;
        
        
        if (length < min)
            return out;
        
        HashMap<String,Integer> dict = new HashMap<String,Integer>();
        
        for (int i = 0; i < num; i++) {
            if (dict.containsKey(L[i])) {
                dict.put(L[i], dict.get(L[i])+1);
            } else {
                dict.put(L[i], 1);
            }
        }
        
       
        for (int i = 0;i <= length-min; i++) {
            HashMap<String,Integer> map = new HashMap<String,Integer>(dict);
            for (int j = 0; j < num;j++) {
                String key = S.substring(i+(j*len), i+(j+1)*len);
                if (map.containsKey(key)) {
                    int v = map.get(key);
                    if (v == 1)
                        map.remove(key);
                    else
                        map.put(key, v-1);
                } else {
                    break;
                }
            }
            
            if (map.isEmpty())
                out.add(i);
        }
        
        
        
        return out;
    }
    
    public static void main(String args[]){
        
    }
}
