import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < normalized.length(); i++) {
            deque.add(normalized.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = strategy.check(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}