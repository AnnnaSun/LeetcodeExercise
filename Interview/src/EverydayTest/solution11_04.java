package src.EverydayTest;
//在一根无限长的数轴上，你站在0的位置。终点在target的位置。
//
//你可以做一些数量的移动 numMoves :
//
//每次你可以选择向左或向右移动。
//第 i次移动（从 i == 1开始，到i == numMoves ），在选择的方向上走 i步。
//给定整数target ，返回 到达目标所需的 最小移动次数(即最小 numMoves )。
//
public class solution11_04 {
    public int reachNumber(int target) {
        int result = 0, num = 0, t = Math.abs(target); // 由于target有负数情况，为了统一计算逻辑，所以取绝对值
        // 直到num值大于等于t，并且num减t是偶数，才结束while循环
        while (num < t || (num - t) % 2 != 0)
            num += ++result; // num=1+2+3+4+……
        return result;

    }

//    由于2*A一定是偶数，所以找到了这个规律后，我们就可以首先只朝一个方向移动
//    （由于target会有负数的情况，所以为了统一计算方式，我们将target取绝对值即可，
//    即：t = Math.abs(target)），
//    只有当移动的总距离 num 的值大于等于 t （target的绝对值），并且 num 减 t 是偶数，才表示当前情况满足题目要求，即：满足到达 target 所需的最小移动次数。
//
}
