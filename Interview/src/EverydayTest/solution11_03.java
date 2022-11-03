package src.EverydayTest;
//给你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。单词 word的 最大重复值是单词word在sequence中最大的重复值。如果word不是sequence的子串，那么重复值k为 0 。
//
//给你一个字符串 sequence和 word，请你返回 最大重复值k 。
public class solution11_03 {
    public static int maxRepeating(String sequence, String word) {
        StringBuilder sebuilder = new StringBuilder();
        for (int i =0;;i++){
            sebuilder.append(word);
            if (sequence.indexOf(sebuilder.toString())<0){
                return i;
            }
        }
    }

}
