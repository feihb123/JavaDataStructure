package DateStructure.search;

public class BinarySearch {
    public static int binarySearch(int []arr,int val){
        int mid;
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            mid = (low+high)/2;
            if(arr[mid] < val){
                low = mid + 1;
            }else if(arr[mid] > val){
                high = mid - 1;
            }else if(arr[mid] == val) {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(arr,4));
    }
}
