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
}
