package leetcode;

import java.util.*;

/**
 * 【游戏中弱角色的数量】
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 * <p>
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 * <p>
 * 返回 弱角色 的数量。
 */
public class NumberOfWeakCharacters1996 {

    public static void main(String[] args) {
        NumberOfWeakCharacters1996 numberOfWeakCharacters1996 = new NumberOfWeakCharacters1996();
        int[][] pro = {{1,1},{2,1},{2,2},{1,2}};
        numberOfWeakCharacters1996.numberOfWeakCharacters2(pro);
    }

    /**
     * 先按攻击力从小到大排， 同攻击力的话 防御力从大到小排。（确保stack的保留的是同攻击力里防御力最大的 来保证 stack里从小到大保留完整的大于链，如果stack为空，即该角色不小于之前所有角色）
     * 用stack来维护比当前角色强的人， 如果stack不为空， 则该角色弱。
     *
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters2(int[][] properties) {

        int length = properties.length;
        if (length < 2) {
            return 0;
        }

        Arrays.sort(properties,new Comparator<int[]>(){
            @Override
            public int compare(int[] p,int[] q){
                if (p[0] != q[0]) {
                    return p[0] - q[0];
                } else {
                    return q[1] - p[1];
                }
            }
        });

        int result = 0;
        Deque<int[]> stack = new LinkedList<int[]>();

        for (int i = length - 1; i >=0; i--) {

            while (!stack.isEmpty()) {
                int[] first = stack.peek();
                if (first[0] > properties[i][0] && first[1] > properties[i][1]) {
                    break;
                }
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result++;
            }

            stack.push(properties[i]);

        }
        return result;
    }


    /**
     * 【两次遍历，超时】
     *
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters(int[][] properties) {

        int result = 0;
        int length = properties.length;
        if (length < 2) {
            return result;
        }

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int[] before = properties[i];
                int[] after = properties[j];
                if (before[0] > after[0] && before[1] > after[1]) {
                    set.add(j);
                }
                if (before[0] < after[0] && before[1] < after[1]) {
                    set.add(i);
                }
            }
        }

        return set.size();
    }

}