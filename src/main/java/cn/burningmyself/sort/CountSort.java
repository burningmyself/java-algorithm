package cn.burningmyself.sort;

/**
 * 计数排序
 * 计数排序是一种非比较排序：
 * <p>
 * 利用一个count数组，统计每个元素arr[i]出现的次数count[arr[i]]，count数组的大小代表的是能排序的元素的最大的值；
 * 然后让count数组中每一个元素count[i]等于其与他前面一项count[i-1]相加，这时候count[arr[i]]表示的值就是小于等于arr[i]的元素的个数，这时就找到了arr[i]在输出数组中的位置；
 * 最后通过反向填充目标数组tmp，将数组元素arr[i] 放在数组tmp的第count[arr[i]]个位置(下标为count[arr[i]]-1)，每放一个元素就将count[arr[i]]递减，可以确保计数排序的稳定性；
 */
public class CountSort {
    /**
     * 计数排序   count 统计数组， tmp 目标填充数组
     */
    public static int[] countSort(int[] arr, int RANGE) { /**数组中最大的元素不能超过 RANGE*/
        int[] count = new int[RANGE + 1];
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        /**现在的count[i]表示小于i的数有count[i]个，排序后元素i就放在第C[i]个输出位置上*/
        for (int i = 1; i <= RANGE; i++)
            count[i] += count[i - 1];
        /**
         * 从后向前扫描保证计数排序的稳定性(重复元素相对次序不变)
         * 当再遇到重复元素时会被放在当前元素的前一个位置上保证计数排序的稳定性
         */
        for (int i = arr.length - 1; i >= 0; i--)
            tmp[--count[arr[i]]] = arr[i];

        //拷贝回原来的数组
        for (int i = 0; i < arr.length; i++)
            arr[i] = tmp[i];
        return arr;
    }
}
