public class MaxOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }

        String result = "";
        while (count > 1) {
            result += "1";
            count--;
        }
        int i = s.length();
        while (i > 0 && result.length() < s.length() - 1) {
            result += "0";
            i--;
        }
        if (count == 1) {
            result += "1";
        }
        return result;
    }

    public static void main(String[] args){
        MaxOddBinaryNumber obj = new MaxOddBinaryNumber();
        String result = obj.maximumOddBinaryNumber("0101");
        System.out.println("result"+result);
    }
}
