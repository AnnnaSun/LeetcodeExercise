package src.EverydayTest;

import java.util.*;

//给你一个 n个点组成的无向图边集edgeList，其中edgeList[i] = [ui, vi, disi]表示点ui 和点vi之间有一条长度为disi的边。请注意，两个点之间可能有 超过一条边。
//
//给你一个查询数组queries，其中queries[j] = [pj, qj, limitj]，你的任务是对于每个查询queries[j]，判断是否存在从pj到qj的路径，且这条路径上的每一条边都 严格小于limitj。
//
//请你返回一个 布尔数组answer，其中answer.length == queries.length，当queries[j]的查询结果为true时，answer 第j个值为true，否则为false。
//
public class solution12_14 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);//edge边从大到小排序

        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);//对于quries进行排序

        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        boolean[] res = new boolean[queries.length];
        int k = 0;
        for (int i : index) {
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                merge(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
        }
        return res;
    }

    public int find(int[] uf, int x) {
        if (uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf, uf[x]);
    }

    public void merge(int[] uf, int x, int y) {
        x = find(uf, x);
        y = find(uf, y);
        uf[y] = x;
    }
}
