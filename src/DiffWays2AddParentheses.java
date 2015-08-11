/*
 * Given a string of numbers and operators, return all possible results from
 *  computing all the different possible ways to group numbers and operators.
 *   The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
 */
import java.util.*;
public class DiffWays2AddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length() == 0)
            return res;

        // scan the string from left to right
        for (int i = 0 ; i < input.length(); i++) {
            char c = input.charAt(i);
            // we are looking for operators here, skip numbers
            if (c != '*' && c != '+' && c != '-')
                continue;
            // now i is the index of operators
            // get result of left part
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            // get result of right part
            List<Integer> right = diffWaysToCompute(input.substring(i+1));
            
            // for all the combination of left part and right part
            for (Integer m:left) {
                for (Integer n:right) {
                    int r = m;
                    // run the operators
                    switch (c) {
                    case '+':
                        r += n;
                        break;
                    case '-':
                        r -= n;
                        break;
                    case '*':
                        r *= n;                    
                    }
                    // add into results
                    res.add(r);
                }
            }
            
        }
        
        // if it goes here, means only digits in the input string
        if (res.isEmpty()) {
            // add the digit into result
            res.add(Integer.parseInt(input));
        }
        
        return res;
    }
    
    public static void main(String args[]) {
        DiffWays2AddParentheses p = new DiffWays2AddParentheses();
        p.diffWaysToCompute("0+1");
    }
}
