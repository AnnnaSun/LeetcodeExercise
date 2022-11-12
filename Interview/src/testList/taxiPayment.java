package src.testList;

import java.util.Scanner;

public class taxiPayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int res = 0;
        for (int n=1; n<=num;n++){
            if (String.valueOf(n).contains("4")){
                continue;
            }
            res++;
        }
        System.out.println(res);
        sc.close();
    }
}
