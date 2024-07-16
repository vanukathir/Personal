import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int derived = - nums[i] - nums[j];
                Integer getIndex = map.get(derived);
                if( getIndex != null && getIndex != i && getIndex != j ){
                    sol.add(nums[i]);
                    sol.add(nums[j]);
                    sol.add(derived);
                    result.add(new ArrayList<>(sol));
                    sol = new ArrayList<>();
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Sum3 obj = new Sum3();
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = obj.threeSum(arr);

        for(List itr : result){
            for(Object val : itr){
                System.out.print(val);
            }
            System.out.println();
        }
    }
}
