package src.EverydayTest;

public class solution11_22 {
    public static int nthMagicalNumber(int n, int a, int b) {
        final long MOD = (long) (1e9+7);
        int acount=1;
        int bcount=1;
        if (n==1)return Math.min(a, b);
        long result=1;
        if (a<b)acount++;
        else if(a>b)bcount++;
        else {
            acount++;
            bcount++;
        }
        for (int i=1; i<n; i++){
            if (acount*a<bcount*b){
                result = acount*a%MOD;
                acount++;
            }
            else if (acount*a>bcount*b){
                result = bcount*b%MOD;
                bcount++;
            }
            else {
                result = acount*a%MOD;
                acount++;
                bcount++;
            }
        }
        return (int) (result%MOD);
    }

    public static void main(String[] args) {
        nthMagicalNumber(1000000000 , 40000 ,40000);
    }
}
