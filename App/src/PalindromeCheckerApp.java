

/**
 * ======================================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ======================================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * @SarathiStacks Developer
 * @version 13.0
 */
import java.util.Scanner;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
    String getName();
}

// Recursive Strategy
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

    @Override
    public String getName() {
        return "Recursive Approach";
    }
}

// Iterative Strategy (Two Pointer)
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

    @Override
    public String getName() {
        return "Iterative (Two Pointer)";
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Strategies
        PalindromeStrategy[] strategies = {
                new RecursivePalindromeStrategy(),
                new IterativePalindromeStrategy()
        };

        System.out.println("\n--- Performance Comparison ---");

        for (PalindromeStrategy strategy : strategies) {

            long startTime = System.nanoTime();

            boolean result = strategy.isPalindrome(input);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println("Algorithm: " + strategy.getName());
            System.out.println("Result   : " + result);
            System.out.println("Time (ns): " + duration);
            System.out.println("-----------------------------");
        }

        sc.close();
    }
}