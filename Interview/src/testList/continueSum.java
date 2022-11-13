package src.testList;

import java.util.Scanner;

public class continueSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int n = sc.nextInt();
        if (sum<n)System.out.println(-1);
        else {
            if ((n%2==1 && sum%n==0) || (sum%n==n/2 && n%2==0)){
                int init = sum/n-(n+1)/2+1;
                for (int i=0; i<n; i++){
                    System.out.print(init++);
                    System.out.print(" ");
                }
            }
            else System.out.println(-1);
        }
    }
}
