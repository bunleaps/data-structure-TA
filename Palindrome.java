import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        isPalindromeStack(input);
        isPalindromeQueue(input);

        scanner.close();
    }

    public static boolean isPalindromeStack(String s) {
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

        System.out.println("\nMODE\t: Stack");

        // Check if the strings are equal
        if (s.equals(reverse)) {
            System.out.printf("Input\t: %s\nReverse\t: %s \nOutput\t: THAT IS A PALINDROME!\n", s, reverse);
            return true;
        } else {
            System.out.printf("Input\t: %s\nReverse\t: %s \nOutput\t: THAT IS NOT A PALINDROME!\n", s, reverse);
            return false;
        }

    }

    public static boolean isPalindromeQueue(String s) {
        Queue<Character> queue = new LinkedList<Character>();
        String reverse = "";

        // Queue all characters
        for (int i = s.length() - 1; i >= 0; i--) {
            queue.add(s.charAt(i));
        }

        // Reverse the string
        while (!queue.isEmpty()) {
            reverse += queue.remove();
        }

        System.out.println("\nMODE\t: Queue");

        // Check if the strings are equal
        if (s.equals(reverse)) {
            System.out.printf("Input\t: %s\nReverse\t: %s \nOutput\t: THAT IS A PALINDROME!\n", s, reverse);
            return true;
        } else {
            System.out.printf("Input\t: %s\nReverse\t: %s \nOutput\t: THAT IS NOT A PALINDROME!\n", s, reverse);
            return false;
        }

    }
}
