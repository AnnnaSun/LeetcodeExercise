数位动态DP
满足x<=n且仅包含digits里出现的数字为x为合法的，找出所有合法x 的个数
假设n为十进制的k位数， 所有数字位数小于 k 且由digits 组成的数字则一定是小于 n 的。
dp[i][0]表示有digits组成且n的前i位的数字的个数， dp[i][1]表示由digits 构成且等于n的前i位的数字的个数， dp[i][1]取值只能为0/1

设digits 中的字符数目为 m个，数字 n 的前 j 位构成的数字为 num[j]，数字 n的第 j个字符为s[j]，当遍历到 n 的第 i位时：

当满足i>1 时，此时任意数字 d构成的数字一定满足d<num[i]；

设数字 a<num[i−1]，则此时在 a的末尾追加一个数字 d构成的数为a×10+d，此时可以知道 d 取0,1,⋯,9 中任意数字均满足小于a×10+d<num[i]=num[i−1]×10+s[i]；

设数字 a=num[i−1]，则此时在 a的末尾追加一个数字 d构成的数为a×10+d，此时可以知道 d<s[i] 时，才能满足a×10+d<num[i]=num[i−1]×10+s[i]；

初始化时令dp[0][1]=1，如果前 ii 位中存在某一位j ，对于任意数字 d均不能满足 d=s[j]，则此时dp[i][1]=0；
根据上述描述从小到到计算 dpdp，设 C[i]C[i] 表示数组 \textit{digits}digits 中小于 nn 的第 ii 位数字的元素个数，则状态转移方程为：

dp[i][0]={
C[i],
m+dp[i−1][0]×m+dp[i−1][1]×C[i]}

#code
class Solution {

public int atMostNGivenDigitSet(String[] digits, int n) {

String s = Integer.toString(n);

int m = digits.length, k = s.length();

int[][] dp = new int[k + 1][2];

dp[0][1] = 1;

for (int i = 1; i <= k; i++) {   
for (int j = 0; j < m; j++) {   
if (digits[j].charAt(0) == s.charAt(i - 1)) {   
dp[i][1] = dp[i - 1][1];   
}
else if (digits[j].charAt(0) < s.charAt(i - 1)) {  
dp[i][0] += dp[i - 1][1];   
} else {   
break;  
}
}  
if (i > 1) {  
dp[i][0] += m + dp[i - 1][0] * m;  
}
}  
return dp[k][0] + dp[k][1];   
}
