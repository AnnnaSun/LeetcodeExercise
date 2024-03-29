package src.EverydayTest;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 */
public class KthNumber {
    public int getKthMagicNumber(int k) {
        int[] numList=new int[k+1];
        int p3=0,p5=0,p7=0;
        numList[0]=1;
        for(int i=1;i<k;i++){
            numList[i]=Math.min(Math.min(numList[p3]*3,numList[p5]*5),numList[p7]*7);
            if(numList[i]==numList[p3]*3) p3++;
            if(numList[i]==numList[p5]*5) p5++;
            if(numList[i]==numList[p7]*7) p7++;
        }
        return numList[k-1];
    }

    /**
     * 解题思路：
     * 不难发现，一个丑数总是由前面的某一个丑数 x3 / x5 / x7 得到。
     * 反过来说也是一样的，一个丑数 x3 / x5 / x7 就会得到某一个更大的丑数
     * 如果把丑数数列叫做 ugly[i]，那么考虑一下三个数列：
     * 1. ugly[0]*3,ugly[1]*3,ugly[2]*3,ugly[3]*3,ugly[4]*3,ugly[5]*3……
     * 2. ugly[0]*5,ugly[1]*5,ugly[2]*5,ugly[3]*5,ugly[4]*5,ugly[5]*5……
     * 3. ugly[0]*7,ugly[1]*7,ugly[2]*7,ugly[3]*7,ugly[4]*7,ugly[5]*7……
     *
     * 上面这个三个数列合在一起就形成了新的、更长的丑数数列。
     *
     * 如果合在一起呢？这其实就是一个合并有序线性表的问题。
     *
     * 定义三个index 分别指向上面三个数列，下一个丑数一定是三个 index 代表的值中最小的那个。然后相应 index++ 即可。
     *
     * 举个例子
     * 初始值 ugly[0]=1; index1=0; index2=0; index3=0
     * ugly[1]=Min(ugly[index1]*3,ugly[index2]*5,ugly[index3]*7)
     * =Min(1*3,1*5,1*7)
     * =3
     * 于是 index1++;
     *
     * ugly[2]=Min(ugly[index1]*3,ugly[index2]*5,ugly[index3]*7)
     * =Min(3*3,1*5,1*7)
     * =5
     * 于是 index2++;
     */
}
