// Uses the integer-based ArrayStack to reverse a word
public class WordReversal {

    // Function to reverse a word using stack
    public static void reverseWord(String word) {
        ArrayStack stack = new ArrayStack(word.length());

        // Step 1: Push each character onto the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push((int) word.charAt(i));
        }

        // Step 2: Pop all characters and print them (reversed order)
        System.out.print("Original Word: " + word + " -> Reversed Word: ");
        while (stack.top != -1) {
            char ch = (char) stack.stack[stack.top];
            stack.pop();
            System.out.print(ch);
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        String[] words = {"hello", "world", "stack", "java", "students"};

        for (String w : words) {
            reverseWord(w);
        }
    }
}
