package cn.burningmyself.sort;

/**
 * 选择排序
 * 在序列中找到最小（大）元素，放到序列的起始位置作为已排序序列；
 * 再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。
 */
public class SelectSort extends Sort {
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;//记录后面最小值下标
            for (int j = i + 1; j < arr.length; j++) {//主意从i+1开始
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }
}
