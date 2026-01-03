public class InfixToPostfix {

    // Helper: check if character is an operator
    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Helper: define precedence of operators
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix expression to postfix
    public static String infixToPostfix(String expression) {
        ArrayStack stack = new ArrayStack(expression.length());
        StringBuilder result = new StringBuilder();

        System.out.println("Converting Infix to Postfix: " + expression);
        System.out.println("----------------------------------------");

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Skip spaces
            if (ch == ' ')
                continue;

            // If operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
                System.out.println("Added operand to result: " + ch);
            }
            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
                System.out.println("Pushed '(' to stack");
            }
            // If ')', pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && (char)stack.stack[stack.top] != '(') {
                    result.append((char)stack.stack[stack.top]);
                    System.out.println("Popped from stack to result: " + (char)stack.stack[stack.top]);
                    stack.pop();
                }
                if (!stack.isEmpty() && (char)stack.stack[stack.top] == '(') {
                    stack.pop(); // remove '('
                    System.out.println("Popped '(' from stack");
                }
            }
            // If operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence((char)stack.stack[stack.top])) {
                    result.append((char)stack.stack[stack.top]);
                    System.out.println("Popped operator from stack to result: " + (char)stack.stack[stack.top]);
                    stack.pop();
                }
                stack.push(ch);
                System.out.println("Pushed operator to stack: " + ch);
            }
        }

        // Pop all remaining operators
        while (!stack.isEmpty()) {
            result.append((char)stack.stack[stack.top]);
            System.out.println("Popped remaining operator: " + (char)stack.stack[stack.top]);
            stack.pop();
        }

        System.out.println("Final Postfix Expression: " + result.toString());
        System.out.println();
        return result.toString();
    }

    // Main function
    public static void main(String[] args) {
        String[] expressions = {
            "A+B*C",
            "(A+B)*C",
            "A+B*(C-D)",
            "A*B+C*D",
            "(A+B)*(C+D)",
            "A+B+C"
        };

        for (String expr : expressions) {
            String postfix = infixToPostfix(expr);
            System.out.println("Infix: " + expr);
            System.out.println("Postfix: " + postfix);
            System.out.println("=====================================");
        }
    }
}
