/**
 * ======================================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ======================================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * No performance comparison is done in this use case.
 * The focus is purely on algorithm interchangeability.
 *
 * The goal is to teach extensible algorithm design.
 *
 * @SarathiStacks Developer
 * @version 12.0
 */

import java.util.Scanner;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Concrete Strategy 1 - Recursive
class RecursivePalindromeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        return check(processed, 0, processed.length() - 1);
    }

    private boolean check(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return check(str, left + 1, right - 1);
    }
}

// Concrete Strategy 2 - Iterative
class IterativePalindromeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = processed.length() - 1;

        while (left < right) {
            if (processed.charAt(left) != processed.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isPalindrome(input);
    }
}

// MAIN CLASS (Must match file name)
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose Algorithm:");
        System.out.println("1. Recursive");
        System.out.println("2. Iterative");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new RecursivePalindromeStrategy();
        } else {
            strategy = new IterativePalindromeStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.executeStrategy(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);

        sc.close();
    }
}