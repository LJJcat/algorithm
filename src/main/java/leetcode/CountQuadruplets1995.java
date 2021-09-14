package leetcode;

/**
 * 【统计特殊四元组】
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * <p>
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 */
public class CountQuadruplets1995 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 5};
        CountQuadruplets1995 countQuadruplets1995 = new CountQuadruplets1995();
        countQuadruplets1995.solute(nums);
    }

    public int solute(int[] nums) {
        int length = nums.length;
        if (length < 4) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    for (int m = k + 1; m < length; m++) {
                        if (nums[i] + nums[j] + nums[k] == nums[m]) {
                            System.out.println(i + "," + j + "," + k + "," + m);
                            result++;
                        }
                    }
                }
            }
        }


        return result;
    }
}