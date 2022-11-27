package src.EverydayTest;

public class solution11_21 {
    public static void main(String[] args) {
        soupServings(100);
    }
    public static double soupServings(int n) {
        int acount = 0;int bcount=0;
        double prex = 0.25;
        double result = 0;
        return deeploop(result, prex, n, acount, bcount);
    }

    public static double deeploop(double result, double prex, int n, int acount, int bcount){
        // 先分A
        while(bcount<n) {

            if (((acount + 100) >= n && bcount < n)) {
                result = result+prex;
            } else {
                prex = prex * 0.25;
                acount+=100;
                deeploop(result, prex, n, acount, bcount);
            }
            if ((acount + 75) >= n) {
                if ((bcount + 25) < n) result = result+prex;
                else if ((bcount + 25) >= n) result = result+prex*0.5;
            } else {
                prex = prex * 0.25;
                acount+=75; bcount+=25;
                deeploop(result, prex, n, acount, bcount);
            }
            if ((acount + 50) >= n) {
                if ((bcount + 50) < n) result = result+prex;
                else if ((bcount + 50) >= n) result = result+prex*0.5;
            } else {
                prex = prex * 0.25;
                acount+=50; bcount+=50;
                deeploop(result, prex, n, acount, bcount);
            }
            if ((acount + 25) >= n) {
                if ((bcount + 75) < n) result = result+prex;
                else if ((bcount + 75) >= n) result = result+prex*0.5;
            } else {
                prex = prex * 0.25;
                acount+=25; bcount+=75;
                deeploop(result,prex, n, acount, bcount);
            }

        }
        return result;
    }
}
