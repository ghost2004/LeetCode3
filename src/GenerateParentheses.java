/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
import java.util.*;
public class GenerateParentheses {
    public void genP(int left, int right, String list, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(list);
            return;
        }
        
        if (left > 0 )
            genP(left-1, right,list+"(", result);
        if (right > 0 && right > left) 
            genP(left, right-1,list+")", result);
            
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        genP(n, n, "", result);
        return result;
    }

}
