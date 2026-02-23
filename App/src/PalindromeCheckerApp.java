/**
 * =========================================================================
 * MAIN CLASS - UseCase5PalindromeCheckerApp
 * =========================================================================
 *
 * Use Case 5: Stack Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 *
 * At this stage, the application:
 * - Pushes characters into a stack
 * - Pops them in reverse order
 * - Compares with original sequence
 * - Displays the result
 *
 * This maps stack behavior to reversal logic.
 *
 * @SarathiStacks Developer
 * @version 5.0
 */

import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // Convert to lowercase for case-insensitive comparison
        input = input.toLowerCase();

        // Convert string to character array
        char[] characters = input.toCharArray();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char ch : characters) {
            stack.push(ch);
        }

        boolean isPalindrome = true;

        // Compare original characters with popped characters
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Output
        System.out.println("Input text: " + input);
        if (isPalindrome) {
            System.out.println("Is it a palindrome: Yes");
        } else {
            System.out.println("Is it a palindrome: No");
        }

        sc.close();
    }
}