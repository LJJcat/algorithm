package order;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 【二路归并】
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 */
public class GuiBingOrder {


    /**
     * 递归  自上而下
     */
    public int[] sort(int[] arr, int left, int right) {
        // 如果 left == right，表示数组只有一个元素，则不用递归排序
        if (left < right) {
            int middle = (left + right) / 2;
            // 对左半部分进行排序
            arr = sort(arr, left, middle);
            // 对右半部分进行排序
            arr = sort(arr, middle + 1, right);
            //进行合并
            merge(arr, left, middle, right);
        }
        return arr;
    }


    /**
     * 合并，将两个有序数组合并起来
     *
     * @param arr
     * @param left
     * @param middle
     * @param right
     */
    private void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }

        }
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= middle) {
            temp[k++] = arr[j++];
        }

        // 把临时数组复制到原数组
        for (int m = 0; m < k; m++) {
            arr[left++] = temp[m];
        }
    }


    /**
     * 非递归
     */
    public int[] sort1(int[] arr) {

        int length = arr.length;
        // 子数组的大小分别为 1，2,4,8
        for (int i = 1; i < length; i = 2 * i) {
            // 数组划分
            int left = 0;
            int middle = left + i -1;
            int right = middle +i;
            // 数组合并，数组大小为 i
            while (right < length) {
                merge(arr, left, middle, right);
                left += i;
                middle = left + i -1;
                right = middle +i;
            }
            // 还有一些被遗漏的数组没合并，千万别忘了,因为不可能每个字数组的大小都刚好为 i
            if(left < length && middle < length){
                merge(arr, left, middle, right);
            }
        }

        return arr;
    }

}