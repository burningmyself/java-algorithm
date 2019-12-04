package cn.burningmyself.sort;

/**
 * 归并排序
 * 归并排序也是分治法一个很好的应用，先递归到最底层，然后从下往上每次两个序列进行归并合起来，是一个由上往下分开，再由下往上合并的过程。
 * 而对于每一次合并操作，对于每一次merge的操作过程如下：
 * <p>
 * 准备一个额外的数组(help)，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * 重复步骤3直到某一指针达到序列尾；
 * 将另一序列剩下的所有元素直接复制到合并序列尾；
 */
public class MergeSort {
    /**
     * 归并排序
     * 注意几点:
     *
     * mergeProcess(arr, L, mid)，不是mid-1；
     * 注意上面的代码中if(arr[mid] > arr[mid+1])防止一开始数组很有序的情况；
     * 注意在外排比较的时候，为了保证稳定性，左右相等的时候，先拷贝左边的；
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return null;
        mergeProcess(arr, 0, arr.length - 1);
        return arr;
    }

    static void mergeProcess(int[] arr, int L, int R) {
        if (L >= R)
            return;  //递归条件判断
        int mid = L + ((R - L) >> 1); //这个相当于 (R+L)/2;
        mergeProcess(arr, L, mid);  //T(n/2),注意不是mid-1
        mergeProcess(arr, mid + 1, R); //T(n/2)
        /**这个是一个优化，因为arr[L,mid]和arr[mid+1,R]已经有序，所以如果满足这个条件，就不要排序了,防止一开始数组有序*/
        if (arr[mid] > arr[mid + 1])
            merge(arr, L, mid, R);  // O(n)
        //整个的表达式  T(n) = 2*T(n/2) + O(n) 使用master公式求出  N*logN
    }

    static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int k = 0;
        int p1 = L, p2 = mid + 1;
        //while(p1 <= mid && p2 <= R)
        //   help[k++] = arr[p1] < arr[p2]  ? arr[p1++] : arr[p2++];
        while (p1 <= mid && p2 <= R)
            help[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];  //左右两边相等的话，就先拷贝左边的(实现稳定性)
        while (p1 <= mid)  //左边剩余的部分
            help[k++] = arr[p1++];
        while (p2 <= R)   //右边剩余的部分
            help[k++] = arr[p2++];
        for (int i = 0; i < k; i++) //拷贝回原来的数组
            arr[i + L] = help[i];
    }
}
