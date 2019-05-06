package sort;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] array={2,4,5,1,9,8,3,6,7};
        mergeSort(array,0,8);
        System.out.println(Arrays.toString(array));
    }

    public static void merge(int a[],int start,int mid,int last){
        int[] temp=new int[last-start+1];
        int i=start;
        int j=mid+1;
        int x=0;
        while(i<=mid && j<=last){
            if(a[i]<a[j]){
                temp[x++] = a[i++];
            }else{
                temp[x++] = a[j++];
            }
        }
        //剩余元素直接移入新数组
        while(i<=mid){
            temp[x++] = a[i++];
        }
        while(j<=last){
            temp[x++] = a[j++];
        }
        //赋值目标数组
        for(int m = 0;m < temp.length;m++){
            a[m+start] = temp[m];
        }
    }


    public static int[] mergeSort(int[] c,int start,int end){
        if(start < end){
            int mid =  (end + start)/2;
            //切分左边
            mergeSort(c,start,mid);
            //切分右边
            mergeSort(c,mid+1,end);
            //合并排序左右数组
            merge(c,start,mid,end);
        }
        return c;
    }


}
