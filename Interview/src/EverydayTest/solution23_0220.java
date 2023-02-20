package src.EverydayTest;

import java.util.HashMap;
import java.util.Map;

public class solution23_0220 {
    public static String bestHand(int[] ranks, char[] suits) {
        char pre = suits[0];
        int suitnum=0;
        for(char c: suits){
            if (c==pre)suitnum++;
            else break;
        }
        if (suitnum == suits.length)return "Flush";
        Map<Integer, Integer> rankrecord = new HashMap<>();
        for (int i: ranks){
            rankrecord.put(i, rankrecord.getOrDefault(i, 0)+1);
        }
        if (rankrecord.containsValue(3) ||  rankrecord.containsValue(4))return "Three of a Kind";
        else if (rankrecord.containsValue(2))return "Pair";
        else return "High Card";
    }

    public static void main(String[] args) {
        bestHand(new int[]{4,4,2,4,4}, new char[]{'d','a','a','b','c'});
    }
}
