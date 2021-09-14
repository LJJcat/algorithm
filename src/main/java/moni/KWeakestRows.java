package moni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <p>
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <p>
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 */
public class KWeakestRows {


    public static void main(String[] args) {
        KWeakestRows kWeakestRows = new KWeakestRows();
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};

        kWeakestRows.kWeakestRows(mat, 3);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        // 记录军人的数量
        int[] junRen = new int[m];
        Map<Integer, List<Integer>> junRenMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < m; i++) {
            // 记录军人数量
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                count++;
            }
            junRen[i] = count;
            List<Integer> indexList = new ArrayList<Integer>();
            if (junRenMap.containsKey(count)) {
                indexList = junRenMap.get(count);
            }
            indexList.add(i);
            junRenMap.put(count, indexList);
        }
        // 军人数量排序
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - i - 1; j++) {
                if (junRen[j + 1] < junRen[j]) {

                    int t = junRen[j];
                    junRen[j] = junRen[j + 1];
                    junRen[j + 1] = t;

                }
            }

        }
        int[] result = new int[k];
        int k1 = 0;
        for (int i = 0; i < m; i++) {
            if (k1 == k) {
                return result;
            }
            List<Integer> indexs = junRenMap.get(junRen[i]);
            int size = indexs.size();
            for (Integer index : indexs) {
                result[k1] = index;
                k1++;
            }
            i = i + size - 1;
        }
        return result;

    }

}