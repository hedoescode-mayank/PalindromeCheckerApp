import java.util.*;

/*
 * Strategy Interface
 */
interface PalindromeStrategy {
    boolean check(String input);
    String getName();
}


/*
 * Stack Strategy
 */
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : cleaned.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public String getName() {
        return "Stack Strategy";
    }
}


/*
 * Deque Strategy
 */
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : cleaned.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    public String getName() {
        return "Deque Strategy";
    }
}


/*
 * Two Pointer Strategy (Optimized)
 */
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String getName() {
        return "Two Pointer Strategy";
    }
}


/*
 * Main Application
 */
public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Performance Comparison App =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        List<PalindromeStrategy> strategies = new ArrayList<>();
        strategies.add(new StackStrategy());
        strategies.add(new DequeStrategy());
        strategies.add(new TwoPointerStrategy());

        System.out.println("\n--- Performance Results ---");

        for (PalindromeStrategy strategy : strategies) {

            long startTime = System.nanoTime();

            boolean result = strategy.check(input);

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Algorithm: " + strategy.getName());
            System.out.println("Result: " + (result ? "Palindrome" : "Not Palindrome"));
            System.out.println("Execution Time: " + duration + " nanoseconds");
            System.out.println("------------------------------------");
        }

        scanner.close();
    }
}