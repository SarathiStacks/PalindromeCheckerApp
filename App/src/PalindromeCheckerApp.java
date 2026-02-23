/**
 * =========================================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * =========================================================================
 * * Use Case 6: Queue + Stack Fairness Check
 * * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 * * - Queue (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 * * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 * * If all characters match, the input string is confirmed
 * as a palindrome.
 * * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 * * @SarathiStacks Developer
 * @version 6.0
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // Convert to lowercase for case-insensitive comparison
        input = input.toLowerCase();

        char[] characters = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Add characters to stack and queue
        for (char ch : characters) {
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        // Compare stack and queue elements
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
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