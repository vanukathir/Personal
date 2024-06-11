import java.util.*;

public class ListArrays {

    public static void main(String[] args){
        ListArrays la = new ListArrays();
        int[] arr = {1,2,3,1};
        boolean result = la.containsDuplicate(arr);
        System.out.println(result);
        System.out.println("Max SubArray:;");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        arr = new int[] {0,4,1,0,0,8,0,0,3};
        la.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("###########################");
        System.out.println("Check if N and double exists");
        arr = new int[] {-2,0,10,-19,4,6,-8};
        result = la.checkIfExist(arr);
        System.out.println(result);
        System.out.println("################################");
        System.out.println("valid mountain array");
        arr = new int[] {9,8,7,6,5,4,3,2,1,0};
        result = la.validMountainArray(arr);
        System.out.println(result);

        System.out.println("#######################");
        System.out.println("sort Array By Parity");
        arr = new int[] {0,1,2};
        arr = la.sortArrayByParity(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("############################");
        System.out.println("max-consecutive-ones-ii");
        arr = new int[] {1,1,1,0,1,1,1,1,1,0,1,1,1,1,1};
        int val = la.findMaxConsecutiveOnes(arr);
        System.out.println(val);

        System.out.println("########################");
        arr = new int[]{2,2,3,1};
        val  = la.thirdMax(arr);
        System.out.println("third Max No:"+ val);
    }

    public int thirdMax(int[] nums) {
        int firstMax = Integer.MIN_VALUE,secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > firstMax ){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }else if(nums[i] > secondMax && nums[i] != firstMax){
                thirdMax = secondMax;
                secondMax = nums[i];
            }else if(nums[i] > thirdMax && nums[i] != firstMax && nums[i] != secondMax){
                thirdMax = nums[i];
            }
        }
        System.out.println("first Max:"+firstMax);
        System.out.println("secondMax:"+secondMax);
        System.out.println("thirdmax:"+thirdMax);
        return (thirdMax !=0) ? thirdMax : (firstMax != 0)? firstMax: -1;

    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right =0 , maxZero = 0 , count = 0;
        while(right < nums.length){
            if(nums[right] == 0)
                maxZero++;
            while(maxZero == 2) {
                if(nums[left] == 0)
                    maxZero--;
                left++;
            }
            right++;
            count = Math.max(count, right - left);
        }
        return count;
    }
    public int[] sortArrayByParity(int[] nums) {
        int oddIndex = 0, evenIndex = 0;
        while(evenIndex < nums.length ){
            if(nums[evenIndex] % 2 == 0) {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
                oddIndex++;
                evenIndex++;
            }else {
                evenIndex++;
            }
        }
        return nums;
    }

    public boolean validMountainArray(int[] arr) {
        int left = 0,i=0 , right = arr.length-1;
        if(arr.length == 2)
            if(arr[left] > arr[right])
                return false;
            else if(arr[left] < arr[right])
                return true;
            else
                return false;
        for( i=1;i<=right;i++){
            if(arr[left] < arr[i])
                left++;
            else
                break;
        }
        if(left == 0 || i > right) return false;
        for(;i<=right;i++){
            if(arr[left] > arr[i])
                left++;
            else
                return false;
        }
        return true;
    }
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 && arr[i] % 2 ==0)
                set.add(arr[i]/2);
        }
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]))
                return true;
        }

        return false;
    }

    public void duplicateZeros(int[] arr) {
        int element = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0 && i+1 < arr.length){
                element = arr[i+1];
                arr[i+1] = 0;
                rightswift(arr,i+2,arr.length,element);
                i = i+1;
            }

        }
    }

    void rightswift(int[] arr,int l,int r,int element){
        while(l < r){
            int temp = arr[l];
            arr[l] = element;
            element = temp;
            l++;
        }
    }
    public boolean containsDuplicate(int[] nums){
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i=1;i<nums.length;i++) {
            if (prev == nums[i])
                return true;
            else
                prev = nums[i];
        }
        return false;
    }
}
