package src.testList;

import java.util.Arrays;
import java.util.Scanner;

public class sortwight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arrays = new int[2][n];
        int[] index = new int[n];
        int[] result = new int[n];
        for (int i=0; i<2; i++){
            for (int j=0; j<n; j++){
                arrays[i][j] = sc.nextInt();
                index[j] = j;
            }
        }
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if (arrays[0][i]>arrays[0][j]||(arrays[0][i]==arrays[0][j] && arrays[1][i]>arrays[1][j])){
                    swap(index, i, j);
                }
            }
        }
        for (int i=0; i<n; i++){
            result[index[i]] = i+1;
        }
        System.out.print(Arrays.toString(result));
    }
    public static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
