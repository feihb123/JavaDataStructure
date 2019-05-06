package sort;

public class BubbleSort {
    public static void main(String[] args) throws InterruptedException {
        int[] array={2,4,5,1,9,8,3,6,11};
        bubble(array);
        show(array);
    }

    public static void bubble(int[] a){
        for(int i=0;i<a.length-1;i++){
            //flag为ture时已排序完成
            boolean flag = true;
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    flag = false;
                }
            }
            if(flag == true){
                break;
            }
        }
    }

    public static void show(int[] a){
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
