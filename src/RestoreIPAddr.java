/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
import java.util.*;
public class RestoreIPAddr {
    public void searchIP(String s, int idx, ArrayList<Short> list, List<String> result) {
        // short list is full and s is not end yet
        if (list.size() >=4 && idx < s.length())
            return;
        
        // the remaining string is not enough
        if (s.length() - idx < 4-list.size())
            return;
        // dump the IP address
        if (idx == s.length() && list.size() == 4) {
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < 3; i++) {
                buf.append(list.get(i));
                buf.append('.');
            }
            buf.append(list.get(3));
            result.add(buf.toString());
            return;
        }
        
        for (int i = idx+1; i < idx+4; i++) {
            if (i > s.length())
                break;
            short b = Short.parseShort(s.substring(idx, i));
            if (b > 255 )
                break;
            // handle the 010 case
            if (s.charAt(idx) == '0' && i > idx+1)
                break;
            int sz = list.size();
            list.add(b);
            searchIP(s, i, list,result);
            list.remove(sz);
            
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4)
            return result;
        ArrayList<Short> list = new ArrayList<Short>();
        searchIP(s, 0, list, result);
        
        return result;
    }

}
