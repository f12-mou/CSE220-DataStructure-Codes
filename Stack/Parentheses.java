// Uses the integer-based ArrayStack for parentheses matching
public class Parentheses {

    // Helper to check matching pairs
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static boolean isBalanced(String expression) {
        ArrayStack stack = new ArrayStack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') // When you get opening bracket, we need to push it on stack
            {
                stack.push((int) ch);
            } else if (ch == ')' || ch == '}' || ch == ']') // We got a closing bracket, we will try to match with the top of the stack
            {
                if (stack.top == -1) return false; // This is due to we have a closing bracket but no opening bracket left in stack
                char open = (char) stack.stack[stack.top];
                stack.pop();

                if (!isMatchingPair(open, ch)) // the opening-closing pair is not matched, imbalanced
                    return false;
            }
        }
        return stack.top == -1; // It will return false if we have extra opening brackets which have no matching closed brackets like ())
    }

    public static void main(String[] args) {
        String[] expressions = {
            "(())", "({})[]", "{{[()()]}}", "(){", "()))"
            
        };

        for (String expr : expressions) {
            boolean result = isBalanced(expr);
            System.out.println(expr + " -> " + (result ? "Balanced" : "Not Balanced"));
        }
    }
    // THE PUSH STATEMENTS ARE PRINTED AS ASCII, SEE ASCII CHART FOR THE (){}[]
}
