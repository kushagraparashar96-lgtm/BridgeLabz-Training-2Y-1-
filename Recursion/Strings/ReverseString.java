package Recursion.Strings;

import java.util.Scanner;

public class ReverseString {
    public static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = reverse(input);

        System.out.println("Reversed string: " + result);

        scanner.close();
    }
}
