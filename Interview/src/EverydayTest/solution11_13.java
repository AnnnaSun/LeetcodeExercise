package src.EverydayTest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class solution11_13 {
    public static String customSortString(String order, String s) {
        char[] orderChar = order.toCharArray();
        char[] resultChar = s.toCharArray();
        Map resultMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i< resultChar.length; i++){
            if (!order.contains(""+resultChar[i])){
                stringBuilder.append(""+resultChar[i]);
                continue;
            }
            for (int j=0; j<orderChar.length; j++){
                if (resultChar[i] == orderChar[j]){
                    if (resultMap.containsKey(orderChar[j])){
                        resultMap.put(orderChar[j], resultMap.get(orderChar[j])+""+resultChar[i]);
                    }
                    else resultMap.put(orderChar[j], resultChar[i]);
                }
            }
        }
        for (char c: orderChar){
            if (resultMap.containsKey(c)) {
                stringBuilder.append("" + resultMap.get(c));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        customSortString("cbafg", "abcd");
    }
}
