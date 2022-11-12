package src.testList;

import java.util.Scanner;

public class minNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] numStr = s.split(",");
        if (numStr.length>=3) {
            int minNums = Integer.parseInt(numStr[0] + numStr[1] + numStr[2]);
            for (int i = 0; i < numStr.length; i++) {
                for (int j = 0; j < numStr.length; j++) {
                    if (j == i) continue;
                    for (int k = 0; k < numStr.length; k++) {
                        if (k == j || k == i) continue;
                        minNums = Math.min(minNums, StringToInt(numStr, i, j, k));
                    }
                }
            }
            System.out.println(minNums);
        }
        else {
            int minNums = Math.min(Integer.parseInt(numStr[0] + numStr[1]), Integer.parseInt(numStr[1] + numStr[0]));
            System.out.println(minNums);
        }
    }
    public static int StringToInt(String[] numStr, int i, int j, int k){
        String s = numStr[i]+numStr[j]+numStr[k];
        int totalNum = Integer.parseInt(s);
        return totalNum;
    }
}
