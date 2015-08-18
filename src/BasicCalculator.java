/*
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
 */
import java.util.Stack;
public class BasicCalculator {
    public int calculate(String s) {

        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        // delete white spaces
        s = s.replaceAll(" ", "");
        for (int i = 0 ; i < s.length();i++) {
            char key = s.charAt(i);
            if (Character.isDigit(key)) {
                int tmp = key - '0';
                int j = i+1;
                while(j<s.length() && Character.isDigit(s.charAt(j))){
                    tmp = tmp * 10 + s.charAt(j) - '0';
                    j++;
                }
                i = j-1;
                if (!ops.isEmpty() && ops.peek() != '(') {
                    char o = ops.pop();
                    if (o == '+') {
                        tmp += nums.pop();
                    } else if (o == '-') {
                        tmp = nums.pop() - tmp;
                    }
                }
                nums.push(tmp);
            } else if (key == '+' || key == '-' || key == '(') {
                ops.push(key);
            } else if (key == ')') {
                char o = ops.pop();
                while (o != '(') {
                    int t2 = nums.pop();
                    int t1 = nums.pop();
                    if (o == '+') {
                        nums.push(t1+t2);
                    } else if (o == '-') {
                        nums.push(t1-t2);
                    }
                    o = ops.pop();
                }
                if (!ops.isEmpty()) {
                    int t2 = nums.pop();
                    int t1 = nums.pop();
                    o = ops.pop();
                    if (o == '+') {
                        nums.push(t1+t2);
                    } else if (o == '-') {
                        nums.push(t1-t2);
                    }
                }
            }
        }
        
        while (!ops.isEmpty()) {
            int t2 = nums.pop();
            int t1 = nums.pop();
            char o = ops.pop();
            if (o == '+') {
                nums.push(t1+t2);
            } else if (o == '-') {
                nums.push(t1-t2);
            }
        }
        
        return nums.peek();
    }
    
    public static void main(String args[]) {
        String s = "(1-(3-4))";
        String s2 = "1-11";
        String s3 = "(7)-(0)+(4)";
                
        BasicCalculator b = new BasicCalculator();
        //System.out.println(b.calculate(s));
        //System.out.println(b.calculate(s2));
        System.out.println(b.calculate(s3));
        
    }
}
