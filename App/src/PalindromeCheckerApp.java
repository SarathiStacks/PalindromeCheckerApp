/**
 * =========================================================================
 * MAIN CLASS - UseCase4PalindromeCheckerApp
 * =========================================================================
 * * Use Case 4: Character Array Based Validation
 * * Description:
 * This class validates a palindrome by converting
 * the string into a character array and comparing
 * characters using the two-pointer technique.
 * * At this stage, the application:
 * - Converts string to char array
 * - Uses start and end pointers
 * - Compares characters efficiently
 * - Displays the result
 * * This reduces extra memory usage.
 * * @SarathiStacks Developer
 * @version 4.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // Convert string to lowercase for case-insensitive comparison
        input = input.toLowerCase();

        // Convert string to character array
        char[] characters = input.toCharArray();

        boolean isPalindrome = true;
        int start = 0;
        int end = characters.length - 1;

        // Compare characters from both ends
        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
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