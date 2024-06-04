import java.sql.Array;

public class ArrayProb {

    void merge(int[] num1,int m, int[] num2, int n){
        int i=0,j=0;
        if(m==0){
            while(j<n){
                num1[i++] = num2[j++];
            }
        }else if (n==0){
            return;
        }
        while(i<m && j<n){
            if(num1[i] <= num2[j])
                i++;
            else if(num1[i] > num2[j]){
                 rightShift(num1,i,m,num2,j);
                 m++;
                 i++;
                 j++;
            }
        }

        while(i<num1.length && j<n){
                num1[i] = num2[j];
                i++;
                j++;

        }

    }

    void rightShift(int[] num1,int i, int m,int[] num2,int j){
        if(m < num1.length)
        for(int index = m-1;index >=i;index--){
            num1[index+1] = num1[index];
        }
        num1[i] = num2[j];
    }

    public static void main(String[] args){
        ArrayProb obj = new ArrayProb();
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        int m = 3;
        int n = 3;
        obj.merge(num1, m, num2, n);
        obj.printArray(num1);
        System.out.println("#####################");
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        val = obj.removeElement(nums,val);
        System.out.println("removed element arra size:"+val);
        System.out.println("array elemenet after removal:");
        obj.printArray(nums);
        System.out.println("##########################");
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        val  = obj.removeDuplicates(arr);
        System.out.println("Distinct element of array Size:"+val);
        obj.printArray(arr);
        System.out.println("###################");
        nums = new int[]{0,0,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3};
        val = obj.removeAndKeep2Duplicates(nums);
        System.out.println("values:"+val);
        obj.printArray(nums);
        System.out.println("#######################");
        System.out.println("Majority Element.");
        nums = new int[]{1,1,1,1,1,1,2,2,2,3,3};
        val = obj.majorityElement(nums);
        System.out.println(val);
        System.out.println("########################");
        nums = new int[] {1,2,3,4,5,6,7,8,9,10};
        int k = 4;
        obj.rotateArray(nums,k);
        obj.printArray(nums);
        System.out.println("#########################");
        nums = new int[] {2,0,0};
        boolean canJump = obj.canJump(nums);
        System.out.println("canJump:"+canJump);
    }
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
             if(i+nums[i] >= lastIndex){
                 lastIndex = i;
             }
        }
        if(lastIndex != 0){
            return false;
        }
        return true;
    }
    public void rotateArray(int[] nums,int k){
        reverseArray(nums,0,nums.length-1);
        reverseArray(nums,0,k);
        reverseArray(nums,k+1,nums.length-1);

    }

    void reverseArray(int[] nums,int s,int e){
        int i=s,j=e;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public int majorityElement(int[] nums) {
        int cand= 0, count = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0){
                cand=i;
            }
            if(nums[cand] ==nums[i]){
                count++;
            }else{
                count--;
            }

        }count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == nums[cand]){
                count++;
            }
        }
        if(count >= nums.length/2){
            return nums[cand];
        }else
            return -1;

    }

    int removeAndKeep2Duplicates(int[] nums){
        int i=1,j=0,size = nums.length;
        int count = 0, intermediate = 0;
        while(i< size){
            if(i-j >=2 && nums[i] == nums[j]){
                rightShiftSingleArray(nums,i,size);
                size--;
            }else if(i!=j && nums[i] == nums[j]){
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        return i;
    }
    int removeDuplicates(int[] nums){
        int prev = 0;
        int count = 0,i=1;
        int size = nums.length;
        while(i<size){
            if( (i!=prev) && nums[i] == nums[prev]) {
                nums = rightShiftSingleArray(nums, i, nums.length);
                count++;
                size--;
            }else{
                prev = i;
                i++;
            }
        }
        return (nums.length-count);
    }

    int[] rightShiftSingleArray(int[] nums,int index,int size){
        for(int j=index;j<size-1;j++){
            nums[j] = nums[j+1];
        }
        nums[size-1] = Integer.MIN_VALUE;
        return nums;
    }
    int removeElement(int[] arr,int val){
        int k = arr.length-1,i=0;
        while(i<=k){
            if(arr[i] == val && arr[k] != arr[i]){
                swap(arr,i,k);
                i++;
                k--;
            }else if(arr[k] == val){
                k--;
            }else{
                i++;
            }
        }
        int count = i;
        System.out.println("count:" +i );
        while(i<arr.length){
            arr[i++] = Integer.MIN_VALUE;
        }
        return count;
    }
    void swap(int[] arr,int i,int k){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
    void printArray(int[] num1){
        for(int i=0;i<num1.length;i++){
            System.out.println(num1[i]);
        }
    }

}
