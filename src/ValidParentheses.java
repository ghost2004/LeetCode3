/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 *  determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are
 all valid but "(]" and "([)]" are not.
 */
import java.util.*;
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();

        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
            case '(':
            case '[':
            case '{':
                stack.push(c);
                break;
            case ')':
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
                break;
            case ']':
                if (stack.isEmpty() || stack.peek() != '[')
                    return false;
                stack.pop();
                break;
            case '}':
                if (stack.isEmpty() || stack.peek() != '{')
                    return false;
                stack.pop();
                break;                
            
            }
            
        }
        
        return (stack.isEmpty());
    }
    
    public boolean isValid2(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) 
                stack.push(c);
            else {
                if (stack.isEmpty() || map.get(stack.peek()) != c)
                    return false;
                stack.pop();
            }
        }
        
        return (stack.isEmpty());
        
    }

}
