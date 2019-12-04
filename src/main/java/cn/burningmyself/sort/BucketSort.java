package cn.burningmyself.sort;

import java.util.Arrays;

/**
 * 桶排序
 * 桶排序的原理可以分为一下三个步骤：
 * 扫描序列，根据每个元素的值所属的区间(可以设置一个映射函数)，放入指定的桶中(顺序放置)；
 *
 * 对每个桶中的元素进行排序，(使用其它排序算法或以递归方式继续使用桶排序）；
 *
 *
 */
public class BucketSort {
    public static final int bucketNum = 100; //桶的个数 0 ～ 9号桶

    //桶排序
    public static int mapToBucket(int x) {   // 映射函数f(x)
        return x / bucketNum;
    }

    /**
     * 桶排序
     * 主要是利用计数排序找到每个桶的起始下标和终止下标，然后对每个桶进行系统的排序；
     * mapToBucket()采用的是 / bucketNum(桶的个数) 的操作，如果对0 ~ 99排序就设置桶的个数为10个，如果是0~999就设置为100个.....；
     * @param arr
     * @return
     */
    public static int[] bucketSort(int[] arr) {
        int[] count = new int[bucketNum];  // 计数数组，存放桶的边界信息
        int[] tmp = new int[arr.length];

        for (int i = 0; i < arr.length; i++)  //count[i]保存着i号桶中元素的个数
            count[mapToBucket(arr[i])]++;

        for (int i = 1; i < bucketNum; i++)  // 定位桶边界初始时，count[i]-1(下标从0开始)为i号桶最后一个元素的位置
            count[i] += count[i - 1];

        //count[0]~count[9]
        for (int i = arr.length - 1; i >= 0; i--)
            tmp[--count[mapToBucket(arr[i])]] = arr[i];

        for (int i = 0; i < arr.length; i++)
            arr[i] = tmp[i];

        //利用计数排序确定各个桶的边界（分桶）
        for (int i = 0; i < bucketNum; i++) {
            int L = count[i];     //count[i]为i号桶第一个元素的位置
            int R = (i == bucketNum - 1 ? arr.length - 1 : count[i + 1] - 1); //count[i+1]-1为i号桶最后一个元素的位置
            //for(int j = L; j <= R; j++)System.out.print( arr[j] + " "); System.out.println();  //print
            if (L < R)  //对每个桶里面进行排序
                Arrays.sort(arr, L, R + 1);//注意这里是R+1，系统库的sort的右边界是开区间
        }

        return  arr;
    }
}
