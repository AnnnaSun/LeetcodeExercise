package src.testList;

import java.util.Arrays;
import java.util.Scanner;

public class sortdiary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] timeStr = new String[n];
        for (int i=0; i<n; i++){
            timeStr[i] = in.next();
        }
        for (int i=0; i<n-1; i++){
            for (int j = i+1; j< n; j++){
                long time1 = StringToLong(timeStr[i]);
                long time2 = StringToLong(timeStr[j]);
                if (time1>time2){
                    swap(timeStr, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(timeStr));

    }

    public static void swap(String[] timeArrays, int i, int j){
        String temp = timeArrays[i];
        timeArrays[i] = timeArrays[j];
        timeArrays[j] = temp;
    }

    public static long StringToLong(String s){
        String[] times = s.split("\\.");
        String ms = times[1];
        if (ms.length()<3){
            int length = ms.length();
            for (int i=0; i<3-length;i++){
                ms = "0"+ms;
            }
        }
        StringBuilder preStr = new StringBuilder();
        String[] preTime = times[0].split(":");
        for (String complexTime: preTime){
            if (complexTime.length()<2){
                preStr.append("0");
            }
            preStr.append(complexTime);
        }
        preStr.append(ms);
        long time = Long.parseLong(preStr.toString());
        return time;
    }
}
