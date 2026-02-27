public class PalindromeCheckerApp {
    public static void main(String[] args) {

        // Hardcoded string
        String text = "madam";

        // Reverse the string
        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        // Check palindrome
        boolean isPalindrome = text.equals(reversed);

        // Print output in required format
        System.out.println("INPUT text : " + text);
        System.out.println("IS it a Palindrome ?: " + isPalindrome);

    }
}