package src.EverydayTest;

import java.util.HashMap;
import java.util.Map;

public class solution20230215 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i: nums){
            numberMap.put(i, numberMap.getOrDefault(i, 0)+1);
        }
        int count=0, rest=0;
        for (Map.Entry<Integer, Integer> entry: numberMap.entrySet()){
            count+= entry.getValue()/2;
            rest+= entry.getValue()%2;
        }
        return new int[]{count, rest};
    }
}
