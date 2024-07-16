public class ReverseString {

        public String reverseStr(String s, int k){
            char[] cArray = s.toCharArray();
            String result = "";
            int start = 0 , interval = k;
            boolean odd = true;
            while(k < cArray.length ) {
                if(odd) {
                    result = reverse(cArray, start, k - 1);
                    cArray = result.toCharArray();
                    k = k + interval;
                    start = start + interval;
                    odd = false;
                }else{
                    odd = true;
                    k = k + interval;
                    start = start+ interval;
                }
            }
            if(start < cArray.length){
                result = reverse(cArray,start,cArray.length-1);
            }
            return result;
        }


        public String reverse(char[] c, int s,int e){
            while(s < e){
                char temp = c[s];
                c[s] = c[e];
                c[e] = temp;
                s++;
                e--;
            }
            return new String(c);
        }

    public static void main(String[] args){
        ReverseString obj = new ReverseString();
        String result = obj.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl",39);
        System.out.println("reversed String based on k:" + result);
    }
}
