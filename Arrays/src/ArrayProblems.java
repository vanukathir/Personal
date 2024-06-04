public class ArrayProblems {
    public int searchElement(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                return i;
            }

        }
        return -1;
    }

    int binarySearch(int[] arr,int low,int high,int target){
        int mid = low + (high-low) /2;
        if(arr[mid] < target){
            return binarySearch(arr,mid+1,high,target);
        }else if(arr[mid] > target){
            return binarySearch(arr,low,mid-1,target);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        ArrayProblems ap = new ArrayProblems();
        int arr[] = {1,4,21,567,1,86,4};
        int searchIndex = ap.searchElement(arr,567);
        System.out.println("Search Element:"+searchIndex);
        System.out.println("Binary Search..");
        int arr1[] = {2,5,8,12,16,23,38,56,72,91};
        searchIndex = ap.binarySearch(arr1, 0,arr1.length-1,23);
        System.out.println("BinarySearch Index:"+searchIndex);
        System.out.println("Ternary Search");
        int arr2[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        searchIndex = ap.ternarySearch(arr2,0,arr2.length-1,6);
        System.out.println("ternary Search:"+searchIndex);
    }
    int ternarySearch(int[] arr,int low,int high,int target){
        if(low < high){
            int m1 = low + (high-low)/3;
            int m2 = high - (high-low)/3;
            if(arr[m1] > target)
                return ternarySearch(arr, low, m1-1,target);
            else if(arr[m2] < target)
                return ternarySearch(arr,m2+1,high , target);
            else if(arr[m1] < target && arr[m2] > target)
                return ternarySearch(arr, m1+1,m2-1,target);
            else if(arr[m1] == target)
                return m1;
            else if(arr[m2] == target)
                return m2;
            else
                return -1;

        }
        return -1;
    }
}
