import java.util.ArrayList;
import java.util.List;

public class BuildArrayPermutation {
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i] = nums[nums[i]];
        }
        return result;
    }

    void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i);
        }
    }
    int goodPairs(int[] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j])
                    count++;
            }
        return count;
    }

    int[] suffle(int[] nums,int n){
        int j = n ,i = 0,k=0;
        int[] result = new int[nums.length];
        for(;i<n;i++){
            if(j<nums.length){
                result[k++] = nums[i];
                result[k++] = nums[j++];
            }
        }
        for(;j<nums.length;j++){
            result[k++] = nums[j];
        }
        return result;
    }
    public ArrayList<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> list = new ArrayList<>();
        Character xters = x;
        for(int i=0;i<words.length;i++){
            if(words[i].contains(xters.toString())){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BuildArrayPermutation obj = new BuildArrayPermutation();
       int arr[] = {0,2,1,5,3,4};
        obj.buildArray(arr);
        obj.printArray(arr);
        int[] result = obj.arrayConcatinnation(arr);
        System.out.println("");
        obj.printArray(result);
        System.out.println("#############");
        int pair[] = {1,2,3,1,1,3};
        int count = obj.goodPairs(pair);

        System.out.println("count:"+count);
        System.out.println("shufffle...");
        int nums[] = {2,5,1,3,4,7};
        nums = obj.suffle(nums, 3);
        obj.printArray(nums);
        String[] str = {"leet" , "extra"};
        System.out.println("words containing...");
        ArrayList list = obj.findWordsContaining(str,'e');
        for(Object l : list) {
            System.out.println(l);
        }

        System.out.println("largest local values in matrix");
        int[][] matrix = {{20,8,20,6,16,16,7,16,8,10},
                {12,15,13,10,20,9,6,18,17,6},
                {12,4,10,13,20,11,15,5,17,1},
                {7,10,14,14,16,5,1,7,3,11},
                {16,2,9,15,9,8,6,1,7,15},
                {18,15,18,8,12,17,19,7,7,8},
                {19,11,15,16,1,3,7,4,7,11},
                {11,6,5,14,12,18,3,20,14,6},
                {4,4,19,6,17,12,8,8,18,8},
                {19,15,14,11,11,13,12,6,16,19}};
        matrix = obj.resultMagicArray(matrix);
        obj.printMatrix(matrix);

        System.out.println("Richest customer wealth..");
        int[][] grid = {{1,5},{7,3},{3,5}};
        int wealth = obj.findMaxWealth(grid);
        System.out.println("max wealth:"+wealth);

        System.out.println("##########################");
        System.out.println("2798. Number of Employees Who Met the Target");
        int[] hours ={0,1,2,3,4};
        int empCount = obj.countEmpMeetTarget(hours,2);
        System.out.println("empCount:"+empCount);
        System.out.println("##########################");
        System.out.println("1431. Kids With the Greatest Number of Candies");
        int[] candies = {2,3,5,1,3};
        boolean[] flag = obj.kidsWithCandies(candies,3);

    }
    boolean[] kidsWithCandies(int[] candies, int extraCandy){
        int max = 0;
        boolean[] result = new boolean[candies.length];
        for(int i=0;i<candies.length;i++){
            if(max < candies[i]){
                max = candies[i];
            }
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandy >= max){
                result[i] = true;
            }else{
                result[i] = false;
            }
        }
        return result;
    }
    int countEmpMeetTarget(int[] hours,int target){
        int count = 0;
        for(int i=0;i<hours.length;i++){
            if(hours[i] >= target)
                count++;
        }
        return count;
    }
    int findMaxWealth(int[][] grid){
        int max = 0,count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                count += grid[i][j];
            }
            if(max < count){
                max = count;
            }
            count = 0;
        }
        return max;
    }
    void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    int[][] resultMagicArray(int[][] grid){
        int result[][] = new int[grid.length-2][grid.length-2];
        int max = 0;
        for(int i=0;i< result.length;i++) {
            for (int j = 0; j < result.length; j++) {
                for(int k=i;k<(i+3);k++){
                    for(int l=j;l<(j+3);l++){
                        if(grid[k][l]>max){
                            max = grid[k][l];
                        }
                    }
                }
                result[i][j] =max;
                max= 0;
            }
        }
        return result;
    }
    private int[] arrayConcatinnation(int[] arr) {
        int[] result = new int[arr.length+arr.length];
        int j=0;
        for(int i=0;i<arr.length;i++){
            result[j] = arr[i];
            j++;
        }
        for(int i=0;i<arr.length;i++){
            result[j]= arr[i];
            j++;
        }
        return result;
    }
}
