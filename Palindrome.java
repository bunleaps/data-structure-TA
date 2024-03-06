import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar")); // true
    }

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<Character>();
        String reverse = "";

        // Stack all characters
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        // Reverse the string
        while (!stack.isEmpty()) {
            reverse += stack.pop();
        }

        // Check if the strings are equal
        return s.equals(reverse);
    }
}
