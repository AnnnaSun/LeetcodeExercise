package src.EverydayTest;

public class solution10_8 {
    public static boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int diffnum = 0;
        char c1 = 0, c2=0;
        for (int i=0; i<chars1.length; i++){
            if (chars1[i] != chars2[i]){
                diffnum+=1;
                if (diffnum == 1) {
                    c1 = chars1[i];
                    c2 = chars2[i];
                }
                else if (diffnum == 2){
                    if (c1 == chars2[i] && c2 == chars1[i]){
                        continue;
                    }
                    else return false;
                }
                else if (diffnum>2)
                    return false;
            }
        }
        if (diffnum == 2 || diffnum ==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
     System.out.println(areAlmostEqual("caa", "aaz"));
    }
}
