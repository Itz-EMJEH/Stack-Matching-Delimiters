package stackdelimiter;


/* Description: This program checks if the (), [] and {} in a sequence
   are matched correctly using a stack.
   Programmed by: <DOMINGUITO, MARK JOEL C.> <BSIT> <48079> <DSA>
   Last Modified: October 23, 2026
   Version: 1.0
   [Acknowledgements: Coding Simplified
                      https://runestone.academy/ns/books/published/javads/basic-ds_simple-balanced-parentheses.html  
                      https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Stack.html
                      Claude Snonnet 5.5 (Anthropic) - prompt: Draft me a simple code based on the activity.]

*/
import java.util.Scanner;
import java.util.Stack;


public class StackDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter stack: ");
        String s = scanner.nextLine();
        boolean valid = true;

        for (int i = 0; i < s.length() && valid; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    valid = false;                       // closing with no opening
                } else {
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                        valid = false;                   // mismatched
                    }
                }
            }
        }

        if (valid && !stack.isEmpty()) valid = false;    // unclosed opening left

        System.out.println(valid ? "Valid" : "Invalid");
    }
}
