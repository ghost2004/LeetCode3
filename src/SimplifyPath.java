/*
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */
import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        String t[] = path.split("/");
        for (int i = 0; i < t.length; i++) {
            // in case of "//", do nothing
            if (t[i].length() == 0)
                continue;
            // in case of ".", do nothing
            if (t[i].equals("."))
                continue;
            
            // in case of ".."
            if (t[i].equals("..")) {
                // remove the last node in the list if it is not empty
                if (!stack.isEmpty())
                    stack.removeLast();
            } else {
                // add the directory to the end of the list
                stack.addLast(t[i]);
            }
            
        }
        
        // return root if list is empty
        if (stack.isEmpty())
            return "/";
        
        // form the complete directory
        String out = "";
        Iterator<String> iter  = stack.iterator();
        while (iter.hasNext()) {
            out += "/";
            String c = iter.next();
            out += c;
        }
        return out;
    }
    
    
}
