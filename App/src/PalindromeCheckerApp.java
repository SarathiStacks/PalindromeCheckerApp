/**
 * ======================================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ======================================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 *
 * The palindrome logic is encapsulated inside a
 * PalindromeService class.
 *
 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 *
 * @SarathiStacks Developer
 * @version 11.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Create service object
        PalindromeService service = new PalindromeService();

        boolean result = service.isPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);

        sc.close();
    }
}

// Service class (Business Logic)
class PalindromeService {

    public boolean isPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Remove spaces and convert to lowercase
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        return checkRecursive(processed, 0, processed.length() - 1);
    }

    // Recursive helper method
    private boolean checkRecursive(String str, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return checkRecursive(str, left + 1, right - 1);
    }
}