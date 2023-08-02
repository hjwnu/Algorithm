import java.util.*;

class Solution {
     public static String solution(String m, String[] musicinfos) {
        m = semiNote(m); // 네오가 기억하는 멜로디(반음처리))

        Map<String, Object> ans = new HashMap<>();
        ans.put("재생시간",0);
        ans.put("노래제목","(None)");

        for(int i =0 ; i < musicinfos.length;i++){
            String[] tmp = musicinfos[i].split(",");
            
            String song = semiNote(tmp[3]); // 곡의 코드 (반음처리)
            int musicLen = song.length(); // 곡의 재생시간

            int playT = playTime(tmp); // 라디오에서 재생된 시간
            String realP = realPlay(song, playT, musicLen); // 라디오에서 재생된 시간만큼 코드반복

            if(realP.contains(m)
               && (int)ans.get("재생시간") < playT){ //라디오에서 재생된 시간이 더 긴 경우만 맵에 저장.
                ans.put("재생시간",playT);
                ans.put("노래제목",tmp[2]);
            }
        }
        return String.valueOf(ans.get("노래제목"));
    }

    public static String semiNote(String code){
        code = code.replace("C#","c")
                .replace("D#","d")
                .replace("F#","f")
                .replace("G#","g")
                .replace("A#","a");
        return code;
    }

    public static String realPlay(String song, int playT, int musicLen){ 
        StringBuilder realPlay= new StringBuilder(song); // 노래코드로 변수 초기화.
        if(playT < musicLen){realPlay.setLength(playT);} // 노래코드보다 실제 재생시간이 짧으면, 길이 줄이기
        else{
            int idx =0;
            while(realPlay.length()<playT){ // 실제 재생시간이 노래코드보다 길면, 그만큼 코드 반복추가
                if(idx==musicLen){idx=0;}
                realPlay.append(song.charAt(idx++));
            }
        }
        return realPlay.toString();
    }
    
    public static int playTime(String[] tmp){
        int startTime = changeToTime(tmp[0]);
        int endTime = changeToTime(tmp[1]);
        return (endTime) - (startTime);
    }
    
    public static int changeToTime(String time){
        String[] T = time.split(":");
        int hour = Integer.parseInt(T[0])*60;
        int min = Integer.parseInt(T[1]);
        return hour+min;
    }
}