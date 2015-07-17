/*
 * Given an array of words and a length L, format the text such that each line has exactly 
 * L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in 
each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of 
spaces on a line do not divide evenly between words, the empty slots on the left will be 
assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted 
between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
 */
import java.util.*;
public class TextJustification {
    public String getSpace(int n) {
        String s = "";
        for (int i = 0;i < n;i++)
            s+=" ";
        return s;
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> out = new ArrayList<String>();
        int idx = 0;
        int accLen = 0;
        int cnt;
        
        while (idx < words.length) {
            accLen = words[idx].length();
            idx++;
            cnt = 1;

            while (idx < words.length && accLen + 1 + words[idx].length()  <=maxWidth) {
                accLen += 1 + words[idx].length();
                idx++;
                cnt++;
            }
            String line = new String();
            if (cnt == 1 || idx >= words.length) {
                // corner case: only one word or last line
                for (int i = cnt; i > 1;i--) 
                    line+=words[idx-i]+" ";
                line += words[idx-1];
                line += getSpace(maxWidth - line.length());
            } else {
                // average space number in this line
                int avg = (maxWidth-accLen+cnt-1)/(cnt-1);
                // extra space in this line
                int extra = (maxWidth-accLen+cnt-1)%(cnt-1);
                for (int i = cnt; i > 1; i--) {
                    // space number followed by this word
                    int sp;
                   
                    if (i > cnt - extra) 
                        // first extra words is avg+1
                        sp = avg+1;
                    else 
                        // otherwise it is just avg
                        sp = avg;
                    // append the word and spaces
                    line+= words[idx-i] + getSpace(sp);
                }
                // last word in this line
                line += getSpace(maxWidth - line.length() - words[idx-1].length());
                line += words[idx-1];
                
            }
            
            out.add(line);
            cnt = 0;
            accLen = 0;
            
        }
        
        return out;
    }
    
    public void printOut(String[] words, int L) {
        List<String> str = this.fullJustify(words, L);
        for (String l:str) {
            System.out.println(l);
        }
        
    }
    
    public static void main(String args[]) {
        TextJustification t = new TextJustification();
        //String a[] = {"a"};
        //t.printOut(a, 1);
        
        //String t3[]={"a","b","c","d","e"};
        //t.printOut(t3, 3);
        
        //String t4[] = {"What","must","be","shall","be."};
        //t.printOut(t4, 12);
        
        String t5[] = {"Here","is","an","example","of","text","justification."};
        t.printOut(t5, 16);
    }

}
