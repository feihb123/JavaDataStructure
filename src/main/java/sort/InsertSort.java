package sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] array={2,4,5,1,9,8,3,6,7};
        insert(array);
        show(array);
    }

    public static void insert(int[] a){
       for(int i=1;i<a.length;i++){
           int temp = a[i];
           int j = i;
           while(j>0 && temp<a[j-1]){
               a[j] = a[j-1];
               j--;
           }
           a[j] = temp;
       }

    }

    public static void show(int[] a){
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
