public class Solution1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (stack.empty() || c - stack.pop() > 2 ) return false;
        }
        return stack.empty();
    }
}

public class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');// directly push right parenthesis if meet left
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
                // will throw StackEmptyException if not check stack if empty
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty(); // stack should be empty if all parenthesis are paired.
    }
}
