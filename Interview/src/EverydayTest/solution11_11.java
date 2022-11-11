package src.EverydayTest;

public class solution11_11 {
    public boolean halvesAreAlike(String s) {
//        String pres = s.substring(0,s.length()/2-1).toLowerCase();
//        String suffixs = s.substring(s.length()/2).toLowerCase();
        int prenum = 0, suffixnum=0;
        String lowerS = s.toLowerCase();
        String initchars = "aeiou";
        for (int i=0; i<s.length();i++){
            char c = lowerS.charAt(i);
            if (initchars.indexOf(""+c)!=-1){
                if (i<s.length()/2)prenum++;
                else suffixnum++;
            }
        }
        if (prenum==suffixnum) return true;
        return false;
    }
}
