package algo;
import java.util.Stack;
class Solution {
    private Stack stack = new Stack();
    public boolean isValid(String s) {
    	    stack.clear();
        char[] arr = s.toCharArray();
        for(int i =0;i<arr.length;i++){
            char ch = arr[i];
            switch(ch) {
                case '{' :
                case '[' :   
                case '(' : stack.push(ch);
                           break;
                case '}' :
                case ']' :   
                case ')' : if(stack.isEmpty())return false;
                           Character top = (Character)stack.peek();
                           if(top == null)return false;
                           else  { stack.pop();
                                   boolean match = match(ch,top);
                                   if(!match)return false;
                                 }
                           break;
                default  : ;    
            }
        }
        if(stack.isEmpty())return true;
        else return false;
    }
    private boolean match(Character ch,Character top) {
        boolean matches = false;
        if(top == '{' && ch == '}' ) matches = true;
        else {
        if(top == '[' && ch == ']' ) matches = true;
        else
        if(top == '(' && ch == ')' ) matches = true;
        }
        return matches;
    }
}
public class ValidParenthesis {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("("));
		System.out.println(s.isValid("()"));
	}

}
