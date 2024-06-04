public class JumpGame {

    public static void main(String[] args){
        JumpGame jg = new JumpGame();
        int[] arr = {1,1,1,1};
        int val = jg.canJump(arr);
        System.out.println("valu:" + val);
    }

    int canJump(int[] arr){
        int left = 0,right =0 , result =0 , maxIndex = 0;
        if(arr.length == 1)
            return result;
        while( right < arr.length-1){
            for(int i=left;i<=right;i++){
                System.out.println("every items"+ (i+arr[i]));
                maxIndex = Math.max(maxIndex, i+arr[i]);
            }
            if(right!= arr.length-1) {
                left = right + 1;
                right = maxIndex;
                result++;
            }

        }
        return result;
    }

    int findMax(int[] arr,int l,int r,int maxValue){
        while(l <= r){
            if(arr[l] > maxValue){
                maxValue = l;
            }
            l++;
        }
        return maxValue;
    }

}
