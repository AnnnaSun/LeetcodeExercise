package src.EverydayTest;
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

public class setZeroes {
//    我们可以用两个标记数组分别记录每一行和每一列是否有零出现。
//
//具体地，我们首先遍历该数组一次，如果某个元素为 00，那么就将该元素所在的行和列所对应标记数组的位置置为 \text{true}true。最后我们再次遍历该数组，用标记数组更新原数组即可。
//
//    时间复杂度：O(mn) 空间复杂度：O(M+N)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
