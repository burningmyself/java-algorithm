package cn.burningmyself.sort;

/**
 * 基数排序
 * 基数排序分为两种模式:
 * Least significant digit (LSD)
 * Most significance digit (MSD)
 */
public class BaseNumSort {
    static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            max = arr[i] > max ? arr[i] : max;
        return max;
    }

    static void lsdRadixProcess(int[] arr, int exp) {
        int[] count = new int[10];
        int[] tmp = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++) count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            tmp[--count[(arr[i] / exp) % 10]] = arr[i];    //根据当前位数字digit来排序，把每个元素A[i]放到它在输出数组B中的正确位置上
        }
        for (int i = 0; i < arr.length; i++) arr[i] = tmp[i];
    }

    /**
     * 基数排序
     * Least significant digit (LSD)
     *
     * @param arr
     */
    public static int[] lsdRadixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) //从低位到高位
            lsdRadixProcess(arr, exp);
        return arr;
    }
}
