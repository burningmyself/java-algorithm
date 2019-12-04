package cn.burningmyself.sort;

/**
 * 希尔排序
 */
public class ShellSort extends Sort {
    /**
     * 希尔排序使更高效的插入排序，它的思想在于，
     * 把数组分成几块，每一块进行一个插入排序；
     * 而分块的依据在于增量的选择分好块之后，从gap开始到n，每一组和它前面的元素（自己组内的）进行插入排序；
     * 每次和组内的元素比较完之后，最后的元素基本就是有序的了，希尔排序相对于插入排序的优势在于插入排序每次只能将数据移动一位，不过希尔排序时间复杂度的大小还是要取决于步长的合适度，另外希尔排序不是一种稳定的排序算法。
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int gap = 0;
        for (; gap <= arr.length; gap = gap * 3 + 1) ;
        for (; gap > 0; gap = (gap - 1) / 3) { //增量序列
            for (int i = gap; i < arr.length; i++) {  //从数组第gap个元素开始
                int key = arr[i], j;  //每个元素与自己组内的数据进行直接插入排序
                for (j = i - gap; j >= 0 && key < arr[j]; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = key;
            }
        }
    }
}
