public class MaxRepeatSubstring {
    public static void main(String[] args){
        MaxRepeatSubstring mr = new MaxRepeatSubstring();
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        int val = mr.maxRepeating(sequence,word);
        System.out.println(val);
    }

    public int maxRepeating(String sequence, String word) {
        int index = 0,count=0;
        int i=0;
        while(i<sequence.length() ){
            if(sequence.charAt(i) == word.charAt(index)){
                System.out.println("index:"+index + " ith iter:"+i + "count:"+count);
                System.out.println(sequence.charAt(i) +" words char:"+word.charAt(index));
                index++;
                i++;

            }
            else {

                System.out.println("non matching:"+sequence.charAt(i) +" words char:"+word.charAt(index));
                index = 0;
                i++;
            }
            if (index > word.length()-1){
                index = 0;
                count++;
            }
        }
        return count;
    }
}
