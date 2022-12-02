package src.EverydayTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
//
//在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
//
//返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
//
//每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
//
public class solution12_2 {
    public static int[] minOperations(String boxes) {
        List<Integer> exist = new ArrayList();

        for (int i=0; i<boxes.length(); i++){
            if (boxes.charAt(i)!='0'){
                exist.add(i);
            }
        }
        int[] res = new int[boxes.length()];
        for (int i=0; i<boxes.length(); i++){
            int sum = 0;
            for (int num: exist) {
                sum+=Math.abs(i-num);
            }
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        minOperations("001011");
    }
}
