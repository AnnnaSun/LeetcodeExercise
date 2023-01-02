package src.EverydayTest;

import java.util.regex.Pattern;

public class solution_230102 {
    public boolean areNumbersAscending(String s) {
        String[] slist = s.split(" ");
        int temp=0;
        Pattern pattern = Pattern.compile("[0-9]*");
        for (String word: slist){
            if (pattern.matcher(word).matches()){
                if (Integer.parseInt(word)>temp)temp = Integer.parseInt(word);
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
