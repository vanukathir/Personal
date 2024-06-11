public class Fiponacci {

    public static void main(String[] args){
        Fiponacci f = new Fiponacci();
        int fip = f.fip(10);
        System.out.println("fip:"+fip);
    }
    int fip(int n){
        int prev1 = 0 , prev2 = 1;
        for(int i=1;i<=n;i++){
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
