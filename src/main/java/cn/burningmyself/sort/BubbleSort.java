package cn.burningmyself.sort;

/***
 * 冒泡排序
 */
public class BubbleSort extends Sort {


    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static int[] bubbleSort(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            int border = 0;//记录上一次最后交换的那个位置border；
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    border = i + 1;//下一轮交换只需要进行到这个位置即可；
                }
            }
            end = border;
        }
        return arr;
    }

    /**
     * 鸡尾酒排序(定向冒泡排序)
     * 它的改进在于同时的冒泡两边，从低到高，然后从高到低；
     * 相当于顺便把最小的数也冒泡到最前面这个方法比冒泡更加高效一点；
     *
     * @param arr
     * @return
     */
    public static int[] cocktailSort(int[] arr) {
        int L = 0;
        int R = arr.length - 1;
        while (L < R) {
            for (int i = L; i < R; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            R--;
            for (int i = R; i > L; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
            L++;
        }
        return arr;
    }
}
