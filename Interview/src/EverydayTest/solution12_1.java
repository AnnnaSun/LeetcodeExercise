package src.EverydayTest;
//给你两个整数x 和y，表示你在一个笛卡尔坐标系下的(x, y)处。同时，在同一个坐标系下给你一个数组points，其中points[i] = [ai, bi]表示在(ai, bi)处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的。
//
//请返回距离你当前位置曼哈顿距离最近的有效点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标最小的一个。如果没有有效点，请返回-1。
//
//两个点 (x1, y1)和 (x2, y2)之间的 曼哈顿距离为abs(x1 - x2) + abs(y1 - y2)。
//
public class solution12_1 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<points.length; i++){
            int[] point = points[i];
            if (x==point[0] || y==point[1]){
                int length = Math.abs(point[0]-x)+Math.abs(point[1]-y);
                if (length< min){
                    min = length;
                    res = i;
                }
            }
        }
        return res;
    }
}
