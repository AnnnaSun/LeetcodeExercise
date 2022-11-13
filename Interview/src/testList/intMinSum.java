package src.testList;

import java.util.Arrays;
import java.util.Scanner;

public class intMinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s2 = sc.nextLine();
        int k = sc.nextInt();
        String[] n1 = s.split(" ");
        String[] n2 = s2.split(" ");
        int len = n1.length;
        int[] num1 = new int[len];
        int[] num2 = new int[len] ;
        for (int i=0; i<len; i++){
            num1[i] = Integer.parseInt(n1[i]);
            num2[i] = Integer.parseInt(n2[i]);
        }
        Arrays.sort(num1);
        Arrays.sort(num2);
        int[] result = new int[len*len];
        int q = 0;
        for (int i=0; i<len; i++){
            for (int j=0; j<len; j++){
                result[q++] = num1[i]+num2[j];
            }
        }
        Arrays.sort(result);
        int sum=0;
        for (int i=0; i<k; i++){
            sum+=result[i];
        }
        System.out.print(sum);
    }
}
