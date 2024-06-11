public class MinCostClimbingStairs {

    public static void main(String[] args){
        MinCostClimbingStairs mc = new MinCostClimbingStairs();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int val = mc.minCostClimbingStairs(cost);
        System.out.println(val);
    }

    public int minCostClimbingStairs(int[] cost){
        int length = cost.length-1;

        cost[length -2 ] = Math.min(cost[length-1], cost[length]);
        for(int i=length-3;i>=0;i--){
            cost[i] += Math.min(cost[i+1] ,cost[i+2] );
        }
        return Math.min(cost[0],cost[1]);
    }
}
