package Arrays.PracticeProblem;

import java.util.Scanner;

public class threeConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int count=0;
        if(!sc.hasNextLine()){
            return;
        }
        for(int i=0;i<=s.length()-3;i++){
            char c1=s.charAt(i);
            char c2= s.charAt(i+1);
            char c3=s.charAt(i+2);
            if(c1!=c2&&c1!=c3&&c2!=c3){
                count++;
            }
        }
        System.out.println(count);
    }
}
