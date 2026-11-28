package Recursion.Strings;

public class CountVowels {

    public static int CountVowels(String s) {
        if (s == null) {
            return 0;
        }
        return countVowelHelper(s, 0);
    }

    private static int countVowelHelper(String s, int index) {
        if (index == s.length()) {
            return 0;
        }

        char ch = s.charAt(index);
        boolean isVowels = "AEIOUaeiou".indexOf(ch) != -1;

        return (isVowels ? 1 : 0) + countVowelHelper(s, index + 1);
    }

    public static void main(String[] args) {
        String text = "Hello World!";
        int result = CountVowels(text);

        System.out.println("Number of vowels in '" + text + "': " + result);
    }
}

