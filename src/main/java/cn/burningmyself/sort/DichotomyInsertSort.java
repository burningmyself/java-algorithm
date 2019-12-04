package cn.burningmyself.sort;

/**
 * 二分插入排序
 */
public class DichotomyInsertSort extends Sort {
    /**
     * 二分插入排序
     * 二分插入排序是对插入排序的一个小小的改进
     * 改进的地方在于在前面已经排好序的序列中找当前要插入的元素的时候采用二分查找的方式去找那个插入的位置(大于key的那个位置)
     * 找到那个位置之后，再进行元素的移动，已及把那个元素插入到找到的那个位置；
     *
     * @param arr
     * @return
     */
    public static int[] dichotomyInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int L = 0, R = i - 1;
            while (L <= R) {
                int mid = L + (R - L) / 2;
                if (arr[mid] > key) R = mid - 1;
                else L = mid + 1;
            }
            //二分结束之后　L = 刚好大于key(不是等于)的那个位置
            for (int j = i - 1; j >= L; j--) {
                arr[j + 1] = arr[j];
            }
            arr[L] = key;
        }
        return arr;
    }
}
