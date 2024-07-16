import java.util.HashMap;
import java.util.Map;

public class RingsRods {

    public int countPoints(String rings) {
        HashMap<Integer,String> map = new HashMap<>();
        int index = 0;
        int val = 1;
        for(int i=0;i< rings.length()-1;i++){
            if(rings.charAt(i) == 'B'){
                val = (int) rings.charAt(i+1);

            }else if(rings.charAt(i) == 'R'){
                 val = (int) rings.charAt(i+1);

            }else if(rings.charAt(i) == 'G'){
                 val = (int) rings.charAt(i+1);

            }
            String existing = map.get(val);
            if(existing != null ) {
                existing += rings.charAt(i);
            }else{
                existing = String.valueOf(rings.charAt(i));
            }
            map.put(val,existing);
        }
        int count = 0;
        for(Map.Entry itr : map.entrySet()){
            if(itr.getValue().toString().contains("R") && itr.getValue().toString().contains("G") && itr.getValue().toString().contains("B")){
                count += 1;
            }
        }
        return count;
    }

    public int countKeyChanges(String s) {

        int count =0;
        for(int i=0;i<s.length()-1;i++){
           char c1 = s.charAt(i);
           char c2 = s.charAt(i+1);
           if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
               count++;
           }
        }
        return count;
    }
    public static void main(String[] args){
        RingsRods rr = new RingsRods();
        int result = rr.countPoints("G4");
        System.out.println(result);
        System.out.println("No of chaing keys..");
        result = rr.countKeyChanges("AaAaAaaA");
        System.out.println(result);

    }


}
