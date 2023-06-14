class Solution {
    public static String[] solution(String[] quiz) {
        String[][] part = new String[quiz.length][5];
        int idx=0;
        for(String str : quiz){
            part[idx] = str.split(" ");idx++;
        }
        
       String[] answer = new String[part.length];
        
        for(int i =0 ; i < part.length;i++) {
            int ans = part[i][1].charAt(0) == '-' ? Integer.parseInt(part[i][0]) - Integer.parseInt(part[i][2]) : Integer.parseInt(part[i][0]) + Integer.parseInt(part[i][2]);
        answer[i] = ans==Integer.parseInt(part[i][4])? "O" : "X";
        }
        return answer;
    }
}