package sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 快排 填坑法
     * @param a  数组
     * @param startIndex 开始下标
     * @param endIndex 结束下标
     */

    public static void quickSort(int[] a,int startIndex,int endIndex){
        if(startIndex < endIndex){
            //left  right 代表左右当前指向元素
            int left = startIndex;
            int right = endIndex;
            //挖出第left的元素
            int temp = a[left];
            //循环结束交换位置后左边都比temp他小，右边都比他大
            while(left < right){
                //右边元素 > temp 指针左移一位
                while(left < right && a[right] > temp){
                    right--;
                }
                //若出现右边元素 < temp，填入left坑中
                if(left < right){
                    a[left++] = a[right];
                }
                while(left < right && a[left] < temp){
                    left++;
                }
                if(left < right){
                    a[right--] = a[left];
                }
            }
            //此时left == right
            a[left] = temp;
            quickSort(a,startIndex,left - 1);
            quickSort(a,left + 1,endIndex);
        }
    }




    /**
     *交换指针元素法
     */
    public static void quickSort2(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分递归排序
        quickSort2(arr, startIndex, pivotIndex - 1);
        quickSort2(arr, pivotIndex + 1, endIndex);
    }
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //注意while和if！
        while( left < right) {
            //控制right指针比较并左移
            while(left<right && arr[right] >= pivot){
                right--;
            }
            //控制right指针比较并右移
            while( left<right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if(left<right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}