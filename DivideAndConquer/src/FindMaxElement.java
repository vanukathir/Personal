public class FindMaxElement {
    public static void main(String[] args) {
        FindMaxElement obj = new FindMaxElement();
        int[] arr = {2, 4, 6, 210, 3, 57, 84};
        int val = obj.findMax(arr, 0, arr.length-1);
        System.out.println("finding max element" + val);
        System.out.println("#########################");
        System.out.println("finding min element:");
        val = obj.findMin(arr,0,arr.length-1);
        System.out.println(val);
        System.out.println("#########################");
        System.out.println("power of x");
        val = obj.pow(5,3);
        System.out.println("power of x:"+val);
    }
    int pow(int x,int n){
        if(n == 1)
            return x;
        else if(n==0)
            return 1;
        else
            return pow(x,n-1) * x ;
    }

    int findMin(int[] arr,int s,int e){
        if(s < e){
            int mid = e - (e-s)/2;
            System.out.println("mid left:"+mid);
            int leftMin = findMin(arr,s,mid-1);
            int rightMin = findMin(arr,mid,e);
            return (leftMin < rightMin ? leftMin: rightMin);
        }else if(s == e)
            return arr[s];
        else
            return -1;
    }

    int findMax(int[] arr, int s, int e) {

        if (s < e) {
            int mid = e - (e - s) / 2;
            int leftMax = findMax(arr, s, mid - 1);
            int rightMax = findMax(arr, mid, e);
            return (leftMax > rightMax ? leftMax : rightMax);
        } else if (s == e)
            return arr[e];
        else
            return -1;
    }
}
