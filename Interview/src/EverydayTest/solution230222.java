package src.EverydayTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class solution230222 {
    public int minimumSwap(String s1, String s2) {
        Map<Character, Integer> map= new HashMap<>();
        int sum=0;
        int x=0, y=0;
        for (int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2){
                if (c1=='x')x++;
                else y++;
                sum++;
            }
        }
        if (sum%2==1)return -1;
        return (x+1)/2+(y+1)/2;
    }
}
