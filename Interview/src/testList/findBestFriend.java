package src.testList;

import java.util.Arrays;
import java.util.Scanner;

public class findBestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] heights = new int[num];
        int[] result = new int[num];
        for (int i=0; i<num; i++){
            heights[i] = sc.nextInt();
        }
        for (int i=0; i<num-1; i++){
            result[i] = 0;
            for (int j=i+1; j<num; j++){
                if (heights[j]>heights[i]){
                    result[i] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
