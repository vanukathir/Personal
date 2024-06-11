public class findPermutationDifference {

    public static void main(String[] args){
        findPermutationDifference fp = new findPermutationDifference();
        int val = fp.findPermutationDifference("abc","bac");
        System.out.println(val);
        System.out.println("Defanging an IP Address");
        String result = fp.defangIPaddr("1.1.1.1");
        System.out.println(result);
    }

    String defangIPaddr(String address){
      return  address.replace(".","[.]");
    }
    public int findPermutationDifference(String s, String t) {
        if(s.length() !=t.length())
            return -1;
        else{
            StringBuilder ss = new StringBuilder(s);
            StringBuilder tt = new StringBuilder(t);
            int result = 0;
            for(int i=0;i<ss.length();i++){
                char c =  ss.charAt(i);
                if(tt.indexOf(String.valueOf(c)) != -1) {
                    result += Math.abs(i - tt.indexOf(String.valueOf(ss.charAt(i))));
                }else{
                    return -1;
                }

            }
            return result;
        }

    }
}
