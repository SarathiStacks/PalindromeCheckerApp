/**
 * ======================================================================
 * MAIN CLASS - UseCase10PalindromeCheckerApp
 * ======================================================================
 *
 * Use Case 10: Normalized Palindrome Validation
 *
 * Description:
 * This class validates a palindrome after preprocessing
 * the input string.
 *
 * Normalization includes:
 * - Removing spaces and symbols
 * - Converting to lowercase
 *
 * This ensures the palindrome check is logical rather
 * than character-format dependent.
 *
 * Example:
 * "A man a plan a canal Panama"
 *
 * @SarathiStacks    Developer
 * @version 10.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive method using index approach (efficient)
    public static boolean isPalindrome(String str, int left, int right) {

        // Base case
        if (left >= right) {
            return true;
        }

        // If characters don't match
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Remove spaces & convert to lowercase
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(processed, 0, processed.length() - 1);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);

        sc.close();
    }
}