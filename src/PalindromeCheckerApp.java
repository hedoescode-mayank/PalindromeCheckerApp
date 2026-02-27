public class PalindromeCheckerApp {
    public static void main(String[] args) {

        // Original string
        String text = "level";

        // Reverse using for loop
        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);   // String concatenation
        }

        // Compare original and reversed using equals()
        boolean isPalindrome = text.equals(reversed);

        // Display result
        System.out.println("Original String : " + text);
        System.out.println("Reversed String : " + reversed);
        System.out.println(" ");
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}