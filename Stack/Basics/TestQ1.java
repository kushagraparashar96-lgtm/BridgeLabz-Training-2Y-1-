package Stack.Basics;

import java.util.Scanner;
import java.util.Stack;

public class TestQ1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s= sc.nextLine();
        String t= sc.nextLine();

        Stack<Integer> a=new Stack<>();
        Stack<Integer> b=new Stack<>();

        for(int ch : s.toCharArray()){
            if(ch=='#'){
                if(!s.isEmpty()){
                    a.pop();
                }
            }
            else{
                a.push(ch);
            }
        }
        for( int ch : t.toCharArray()){
            if(ch=='#'){
                if(!t.isEmpty()){
                    b.pop();
                }
            }
            else{
                 b.push(ch);
            }
        }
        System.out.println(a.equals(b));
    }
}
