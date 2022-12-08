package src.EverydayTest;

//给你一个整数n，如果你可以将n表示成若干个不同的三的幂之和，请你返回true，否则请返回 false。
//
//对于一个整数 y，如果存在整数 x满足 y == 3x，我们称这个整数 y是三的幂。
//
public class solution12_9 {
    public boolean checkPowersOfThree(int n) {
        if ((n%3 !=0) &&((n-1)%3!=0))return false;
        int m=0;
        while(n>=3){
            n=n/3;
            m=n%3;
            if (m==2)return false;
        }
        if (n==2)return false;
        else return true;
    }
}
