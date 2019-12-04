package cn.burningmyself.sort;

/**
 * 插入排序
 */
public class InsertSort extends Sort {
    /**
     * 插入排序
     * 从第一个元素开始，该元素可以看作已经排好序；
     * 取出下一个元素，从这个元素从后往前开始扫描，如果该元素大于新元素，将该元素移到下一位置；
     * 重复上述步骤，直到找到已排序的元素小于或者等于新元素的位置，将新元素插入到该位置后；
     * 注意插入排序和数据状况有关系，涉及到最好情况，最差情况和平均情况。
     * 插入排序在工程上，当数组元素个数少的时候用的多，因为如果数组比较有序的话，会很快；
     */
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }
}
