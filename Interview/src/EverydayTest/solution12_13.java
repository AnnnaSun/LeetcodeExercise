package src.EverydayTest;

//全字母句 指包含英语字母表中每个字母至少一次的句子。
public class solution12_13 {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length()<26) return false;
        int[] records = new int[26];
        int len = sentence.length();
        int n = 0;
        for (int i=0; i<len; i++){
            if(records[sentence.charAt(i)-'a']==0){
                n++;
                records[sentence.charAt(i)-'a']=1;
            }
            else {
                if ((len-i-1+n)<26)return false;
            }
        }
        return n==26;
    }
}
