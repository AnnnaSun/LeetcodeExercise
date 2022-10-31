package src.EverydayTest;
//str的构造：
//index = 0，str = “”，尾部添加一个'1'，str更新为“1”
//index = 1，str = “1”，尾部添加str[index] - '0' = 2个 ‘2’，str 更新为 “122”，
//index = 2，str = “122”，尾部添加str[index] - '0' = 2个 ‘1’，str 更新为 “122 11”，
//index = 3，str = “12211”，尾部添加str[index] - '0' = 1个 ‘2’，str更新为“12211 2”
//index = 4，str = “122112”，尾部添加str[index] - '0' = 1个 ‘1’，str更新 “122112 1”，
//index = 5，str = “1221121”，尾部添加str[index] - '0' = 2个 ‘2’，str更新为“1221121 22”
//index = 6，str = “122112122”，尾部添加str[index] - '0' = 1个‘1’，str 更新 “122112122 1”，
//index = 7，str = “1221121221”，尾部添加str[index] - '0' = 2个‘2’，str更新为“1221121221 22”
//...
public class solution10_31 {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        for (int i=2;  sb.length() < n;){
            for (int j = sb.charAt(i++) - '0'; j-- > 0; ) sb.append('1');
            for (int j = sb.charAt(i++) - '0'; j-- > 0; ) sb.append('2');
        }
        int res =0;
        for (int i=0; i<n; i++){
            if (sb.charAt(i) == '1') res++;
        }
        return res;
    }
}
