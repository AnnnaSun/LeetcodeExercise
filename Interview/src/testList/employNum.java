package src.testList;

import java.util.Scanner;

public class employNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int emp = sc.nextInt();
        int charNum = sc.nextInt();
        double preSum = Math.pow(26, charNum);
        int i=1;
        while(preSum*10<emp){
            i++;
        }
        System.out.println(i);
    }
}
