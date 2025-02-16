class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int lateDay, limit;
        int answer = 0;
        for(int i = 0; i < schedules.length;i++){
            lateDay = 0;
            limit = schedules[i] % 100 >= 50 ? schedules[i]+50 : schedules[i]+10;
            for(int j = 0; j < timelogs[i].length;j++){
                int day = j+startday > 7 ? j+startday-7 : j+startday;
                if(day >= 6){
                    continue;
                }
                if(timelogs[i][j] > limit){
                    lateDay++;
                }
            }
            if(lateDay == 0){answer++;}
        }
        return answer;
    }
}