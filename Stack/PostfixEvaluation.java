// Uses ArrayStack to evaluate a Postfix expression
public class PostfixEvaluation {

    // Function to check if a character is an operator
    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    // Function to perform the operation
    private static int performOperation(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;  // assuming integer division
            default: return 0;
        }
    }

    // Function to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        ArrayStack stack = new ArrayStack(expression.length());

        System.out.println("Evaluating Postfix Expression: " + expression);
        System.out.println("--------------------------------------");

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If operand, push to stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');  // convert char to int
                System.out.println("Pushed operand: " + (ch - '0'));
            }
            // If operator, pop two operands and apply
            else if (isOperator(ch)) {
                int b = stack.peek();
                stack.pop();
                int a = stack.peek();
                stack.pop();

                int result = performOperation(a, b, ch);
                System.out.println("Operation: " + a + " " + ch + " " + b + " = " + result);
                stack.push(result);
            }
        }

        // Final result will be at the top
        int finalResult = stack.stack[stack.top];
        System.out.println("Final Result: " + finalResult);
        System.out.println();
        return finalResult;
    }

    // Main function
    public static void main(String[] args) {
        String[] expressions = {
            "23*54*+9-",
            "82/3-32*+",
            "52+83-*4/",
            "56+7*"
        };

        for (String expr : expressions) {
            int result = evaluatePostfix(expr);
            System.out.println("Expression: " + expr + " -> Result: " + result);
            System.out.println("======================================");
        }
    }
}
