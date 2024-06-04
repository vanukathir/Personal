import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[] {map.get(nums[i]),i};
            }
            int diff = target - nums[i];
            map.put(diff,i);
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        ts.twoSum(new int[] {2,7,11,15} , 9);
    }
}
