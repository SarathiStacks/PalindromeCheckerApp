/**
 * =========================================================================
 * MAIN CLASS - UseCase3PalindromeCheckerApp
 * =========================================================================
 * * Use Case 3: Reverse String Based Palindrome Check
 * * Description:
 * This class checks whether a string is a palindrome
 * by reversing the string and comparing it with
 * the original value.
 * * At this stage, the application:
 * - Iterates the string in reverse order
 * - Builds a reversed version
 * - Compares original and reversed strings
 * - Displays the validation result
 * * This introduces transformation-based validation.
 * * @SarathiStacks Developer
 * @version 3.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker (Reversal Method) ===");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        // Remove spaces and special characters, convert to lowercase
        String processedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String reversed = reverseString(processedInput);

        if (processedInput.equals(reversed)) {
            System.out.println("Is it a palindrome: Yes");
        } else {
            System.out.println("Is it a palindrome: No");
        }

        scanner.close();
    }

    public static String reverseString(String text) {

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        return reversed;
    }
}