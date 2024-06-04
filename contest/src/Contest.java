import java.util.Arrays;

public class Contest {

    public static void main(String[] args){
        Contest obj = new Contest();
        int val = obj.minimumChairs("ELEELEELLL");
        System.out.println(val);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        val = obj.countDays(6,new int[][]{{1,6}});
        System.out.println(val);
        System.out.println("####################");
        val = obj.countDays_Sort(14,new int[][]{{6,11},{7,13}, {8,9}, {5,8},{3,13},{11,13},{1,3},{5,10},{8,13},{3,9}});
        System.out.println(val);
    }

    int countDays_Sort(int days,int[][] meetings){
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int j=0,count=0;
        if(meetings.length  == 0)
            return days;
        if(meetings.length == 1 ){
            return (days - meetings[0][1] );
        }
        if(meetings[0][0] != 1){
            count += meetings[0][0]-1;
        }
        for(int i=0;i<meetings.length-1;i++){
            if(meetings[i][1] < meetings[i+1][0]){
                count += meetings[i+1][0] - meetings[i][1]-1;
            }
        }
        if(days != meetings[meetings.length-1][1]){
            count+= days - meetings[meetings.length-1][1];
        }

        return count;
    }

    public int countDays(int days, int[][] meetings) {
        int[] meetingDays = new int[days+1];
        for(int i=0;i<meetings.length;i++){
            int[] day = meetings[i];
            for(int j=day[0];j<=day[day.length-1];j++){
                    meetingDays[j] = 1;
            }
        }
        int count = 0;
        for(int i=1;i<meetingDays.length;i++){
            if(meetingDays[i] != 1){
                count++;
            }
        }
        return count;
    }

    int minimumChairs(String s){
        int maxChair = 0,count= 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'E'){
                count++;
            }else if(s.charAt(i) == 'L'){
                count--;
            }
            if(count > maxChair){
                maxChair = count;
            }
        }
        return maxChair;
    }
}
