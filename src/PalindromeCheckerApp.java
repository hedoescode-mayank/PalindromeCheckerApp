import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        // Convert string to character array
        char[] characters = text.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }


        System.out.println("INPUT text : " + text);
        System.out.println("IS it a Palindrome ?: " + isPalindrome);

        scanner.close();
    }
}