public class BinarySearch {
    public static void main(String[] args){
        BinarySearch bs = new BinarySearch();
        int[] nums = {-1,0,3,5,7,12};
        int index = bs.search(nums,9);
        System.out.println("Binary Search:"+index);
        System.out.println("##########################");
        System.out.println("Find Smallest Letter Greater Than Target");
        char letters[] = {'c','f','j','k'};
        char target = 'k';
        target = bs.nextGreatestLetter(letters,target);
        System.out.println("char: "+ target);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0, e= letters.length-1;
        return binarySearch(letters , s,e,target);
    }

    private char binarySearch(char[] letters,int s,int e, char target) {
        if (s <= e) {
            int mid = e - (e - s) / 2;
            if (letters[mid] == target) {
                return binarySearch(letters, mid + 1, e, target);
            } else if (letters[mid] < target)
                return binarySearch(letters, s, mid - 1, target);
            else
                return binarySearch(letters, mid + 1, e, target);


        }
        return letters[s];
    }

    public int search(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        return binarySearch(nums,s,e,target);
    }
    int binarySearch(int[] nums,int s,int e,int target){
       int mid = 0;
        if(s <= e){
             mid = e - (e - s)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                return binarySearch(nums,mid+1,e,target);
            else
                return binarySearch(nums,s,mid-1,target);

        }
        return s;
    }
}
