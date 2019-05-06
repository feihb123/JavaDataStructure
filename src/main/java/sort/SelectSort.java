package sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] array={2,4,5,1,9,8,3,6,7};
        select(array);
        show(array);
    }

    public static void select(int[] a){
       for(int i=0;i<a.length-1;i++){
           int min=i;
           for(int j=i+1;j<a.length;j++){
               if(a[j]<a[min]){
                   min = j;
               }
           }
           if(min!=i){
               int temp = a[i];
               a[i] = a[min];
               a[min] = temp;
           }
       }

    }

    public static void show(int[] a){
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
