/**
 * ============================================================
 * MAIN CLASS - UseCase2PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 2: Hardcoded Palindrome Validation
 *
 * Description:
 * This class demonstrates basic palindrome validation
 * using a hardcoded string value.
 *
 * At this stage, the application:
 * - Stores a predefined string
 * - Compares characters from both ends
 * - Determines whether the string is a palindrome
 * - Displays the result on the console
 *
 * This use case introduces fundamental comparison logic
 * before using advanced data structures.
 *
 * @SarathiStacks Developer
 * @version 2.0
 */



import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker ===");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        // Remove spaces and special characters, convert to lowercase
        String processedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = checkPalindrome(processedInput);

        if (isPalindrome) {
            System.out.println("Is it a palindrome: Yes");
        } else {
            System.out.println("Is it a palindrome: No");
        }

        scanner.close();
    }

    public static boolean checkPalindrome(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}