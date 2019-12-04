package cn.burningmyself.sort;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SortTest {
    @Test
    public void Sort() {
        int[] arr = {3, 2, 5, 1};
        arr =  BucketSort.bucketSort(arr);
        assertTrue(arr[0] == 1);
    }


}


