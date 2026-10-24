package stackdelimiter;

/* Description: This program checks if the (), [] and {} in a sequence
   are matched correctly using a stack. It also shows the stack
   operations (PUSH, PEEK, POP) while the sequence is being checked.
   It also ignores other characters (letters numbers and etc.)
   Programmed by: <DOMINGUITO, MARK JOEL C.> <BSIT> <48079> <DSA>
   Last Modified: October 23, 2026
   Version: 2.0
   [Acknowledgements: Coding Simplified
                      https://runestone.academy/ns/books/published/javads/basic-ds_simple-balanced-parentheses.html
                      https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Stack.html
                      Claude Snonnet 5.5 (Anthropic) - prompt: Draft me a simple code based on the activity.
                      ]
*/
import java.util.Scanner;
import java.util.Stack;

public class StackDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();

        System.out.print("Enter Stack: ");
        String s = scanner.nextLine();

        boolean valid = true;
        String reason = "";

        
        System.out.println("Input: " + s);
        System.out.println();
      
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // opening delimiter push
            if (c == '(' || c == '[' || c == '{') {
                System.out.println("Read: " + c);
                stack.push(c);
                System.out.println("Operation: PUSH " + c);
                System.out.println("Stack: " + stack);
                System.out.println();
            }
            // closing delimiter check, peek, then pop
            else if (c == ')' || c == ']' || c == '}') {
                System.out.println("Read: " + c);

                // check if the stack is empty
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty, nothing to match with " + c);
                    valid = false;
                    reason = "closing delimiter has no matching opening delimiter";
                    break;
                }

                //  peek
                char top = stack.peek();
                System.out.println("PEEK:" + top);

                // determine if the top is the correct opening delimiter
                if ((c == ')' && top == '(') ||
                    (c == ']' && top == '[') ||
                    (c == '}' && top == '{')) {
                    // if match pop
                    stack.pop();
                    System.out.println("POP: " + top);
                    System.out.println("Stack: " + stack);
                    System.out.println();
                }
                else {
                    valid = false;
                    reason = "mismatched delimiters (" + c + " does not match " + top + ")";
                    break;
                }
            }
        }

        // after reading everything, the stack must be empty
        if (valid && !stack.isEmpty()) {
            valid = false;
            reason = "unmatched opening delimiter remains " + stack;
        }

        if (valid) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Reason: " + reason);
            System.out.println("Invalid");
        }
    }
}
