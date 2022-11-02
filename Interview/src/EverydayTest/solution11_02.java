package src.EverydayTest;
//给你一个数组 towers和一个整数 radius 。
//
//数组 towers 中包含一些网络信号塔，其中towers[i] = [xi, yi, qi]表示第i个网络信号塔的坐标是(xi, yi)且信号强度参数为qi。所有坐标都是在 X-Y 坐标系内的整数坐标。两个坐标之间的距离用 欧几里得距离计算。
//
//整数radius表示一个塔 能到达的 最远距离。如果一个坐标跟塔的距离在 radius以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius以外的距离该塔是 不能到达的。
//
//如果第 i个塔能到达 (x, y)，那么该塔在此处的信号为⌊qi / (1 + d)⌋，其中d是塔跟此坐标的距离。一个坐标的 信号强度 是所有 能到达该坐标的塔的信号强度之和。
//
//请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点(cx, cy) 。如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。
public class solution11_02 {
    public static int[] bestCoordinate(int[][] towers, int radius) {
        int x,y;
        int resulx=0,resulty=0;
        double max = 0;
        for (int i=0; i<towers.length;i++){
            x=towers[i][0];
            y = towers[i][1];
            double length=0;
            for (int j=0; j<towers.length;j++){
                double range = Math.sqrt((x-towers[j][0])*(x-towers[j][0])+ (y-towers[j][1])*(y-towers[j][1]));
                if (range <= radius) {
                    length += towers[j][2]/(1+range);
                }
            }
            if (max < length){
                resulx = x;
                resulty= y;
                max = length;
            }
        }
        return new int[]{resulx, resulty};

    }

    public static void main(String[] args) {
        bestCoordinate(new int[][]{{42, 0, 0}}, 7);
    }
}
