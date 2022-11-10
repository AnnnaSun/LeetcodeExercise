package src.EverydayTest;

import java.util.*;

public class solution11_10 {
    class Solution {
//        预设四个方向
        static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int shortestPathAllKeys(String[] grid) {
            int m = grid.length, n = grid[0].length();
            int sx = 0, sy = 0;
            Map<Character, Integer> keyToIndex = new HashMap<Character, Integer>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
//                    获得起点位置和钥匙的数量
                    if (grid[i].charAt(j) == '@') {
                        sx = i;
                        sy = j;
                    } else if (Character.isLowerCase(grid[i].charAt(j))) {
                        if (!keyToIndex.containsKey(grid[i].charAt(j))) {
                            int idx = keyToIndex.size();
                            keyToIndex.put(grid[i].charAt(j), idx);
                        }
                    }
                }
            }

            Queue<int[]> queue = new ArrayDeque<int[]>();
            int[][][] dist = new int[m][n][1 << keyToIndex.size()];
//            初始化每个位置的步数为-1
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    Arrays.fill(dist[i][j], -1);
                }
            }
//            将起点位置放进队列中
            queue.offer(new int[]{sx, sy, 0});
            dist[sx][sy][0] = 0;
//            队列不为空的时候
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int x = arr[0], y = arr[1], mask = arr[2];
//                朝四个方向开始衍生，坐标最开始为起点坐标，后续会根据下一步是墙还是通道将新的坐标放进query里
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
//                    不过数组外，并且当前位置不是墙
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx].charAt(ny) != '#') {
//                        到达的位置空或者是起点，并且并没有走过，位置加1
                        if (grid[nx].charAt(ny) == '.' || grid[nx].charAt(ny) == '@') {
                            if (dist[nx][ny][mask] == -1) {
                                dist[nx][ny][mask] = dist[x][y][mask] + 1;
//                                将新的位置放进队列
                                queue.offer(new int[]{nx, ny, mask});
                            }
//                            到达的位置是钥匙，获取钥匙的数量
                        } else if (Character.isLowerCase(grid[nx].charAt(ny))) {
                            int idx = keyToIndex.get(grid[nx].charAt(ny));
//                            到达的位置没有被走过
                            if (dist[nx][ny][mask | (1 << idx)] == -1) {
                                dist[nx][ny][mask | (1 << idx)] = dist[x][y][mask] + 1;
//                                如果钥匙被取完了直接退出
                                if ((mask | (1 << idx)) == (1 << keyToIndex.size()) - 1) {
                                    return dist[nx][ny][mask | (1 << idx)];
                                }
//                                将新的位置放进队列
                                queue.offer(new int[]{nx, ny, mask | (1 << idx)});
                            }
                        } else {
//                            到达的位置是锁
                            int idx = keyToIndex.get(Character.toLowerCase(grid[nx].charAt(ny)));
//                            取到了对应的钥匙并且路没走过，就+1
                            if ((mask & (1 << idx)) != 0 && dist[nx][ny][mask] == -1) {
                                dist[nx][ny][mask] = dist[x][y][mask] + 1;
                                queue.offer(new int[]{nx, ny, mask});
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }

}
