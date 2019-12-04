package cn.burningmyself.sort;

/**
 * 堆排序
 * 堆排序的过程是一个反复调整堆的过程：
 *
 * 利用数组建立一个大根堆（父亲比孩子的值大）；
 * 把堆顶元素和堆尾元素互换；
 * 把堆（无序区）的尺寸缩小1，并调用siftDown(arr, 0,len-1)从新的堆顶元素开始进行堆调整；
 * 重复步骤，直到堆的大小为1；
 */
public class StackSort extends Sort {
    public static int[] StackSort(int[] arr) {
        if (arr == null || arr.length <= 1) return null;
        int size = arr.length - 1;
        for (int i = (size - 1) / 2; i >= 0; i--)
            siftDown(arr, i, size + 1);// 注意这里是size+1,因为这个不是交换了最后一个，所以要考虑arr[size]，下面不要考虑arr[size]
        swap(arr, 0, size);//和最后一个数交换
        while (size > 0) {
            siftDown(arr, 0, size);
            swap(arr, 0, --size);
        }
        return arr;
    }

    //递归的调整A[i]以下的堆
    static void siftDown(int[] arr, int i, int size) { //从A[i] 开始往下调整
        int L = 2 * i + 1; //左孩子的下标
        int R = 2 * i + 2;//右孩子的下标
        int maxIdx = i;
        if (L < size && arr[L] > arr[maxIdx]) maxIdx = L;
        if (R < size && arr[R] > arr[maxIdx]) maxIdx = R;
        if (maxIdx != i) {
            swap(arr, i, maxIdx);  //把当前结点和它的最大(直接)子节点进行交换
            siftDown(arr, maxIdx, size);  //继续调整它的孩子
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
