package Recursion.Strings;

public class CharacterReplacer {

    public static String ReplaceAWithB(String s){
        if(s==null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        replaceHelper(s,0,sb);
        return sb.toString();
    }
    private static void replaceHelper(String s , int index, StringBuilder sb) {
        if (index == s.length()) {
            return;
        }
        char current = s.charAt(index);
        sb.append(current == 'a' ? 'b' : current);

        replaceHelper(s, index + 1, sb);
    }
    public static void main(String[] args) {
        String text = "banana and apple";

        String result = ReplaceAWithB(text);

        System.out.println("Original: " + text);
        System.out.println("Modified: " + result);
}
}
