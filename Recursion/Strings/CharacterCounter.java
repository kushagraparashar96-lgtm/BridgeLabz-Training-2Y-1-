package Recursion.Strings;

public class CharacterCounter {
    public static int countChar(String s, char target) {
        if (s == null) {
            return 0;
        }
        return countCharHelper(s, target, 0);
    }

    private static int countCharHelper(String s, char target, int index) {
        if (index == s.length()) {
            return 0;
        }

        boolean matches = s.charAt(index) == target;

        return (matches ? 1 : 0) + countCharHelper(s, target, index + 1);
    }

    public static void main(String[] args) {
        String text = "Hello World!";
        char target = 'l';

        int result = countChar(text, target);

        System.out.println("Occurrences of '" + target + "' in '" + text + "': " + result);
    }
}
