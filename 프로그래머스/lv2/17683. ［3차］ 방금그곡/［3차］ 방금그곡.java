import java.util.*;

class Solution {
     public static String solution(String m, String[] musicinfos) {
        m = semiNote(m); // 네오가 기억하는 멜로디

        Map<String, Object> ans = new HashMap<>();
        ans.put("time",0);
        ans.put("name","(None)");

        for(int i =0 ; i < musicinfos.length;i++){
            String[] tmp = musicinfos[i].split(",");
            
            String song = semiNote(tmp[3]); // 곡의 코드 (반음처리)
            int musicLen = song.length(); // 곡의 재생시간

            int playT = playTime(tmp); // 라디오에서 재생된 시간
            String realP = realPlay(song, playT, musicLen); // 라디오에서 재생된 코드 (반음처리)

            if(realP.contains(m)&& (int)ans.get("time") < playT){
                ans.put("time",playT);
                ans.put("name",tmp[2]);
            }
        }

        return String.valueOf(ans.get("name"));
    }

    public static String semiNote(String note){
        note = note.replace("C#","c")
                .replace("D#","d")
                .replace("F#","f")
                .replace("G#","g")
                .replace("A#","a");

        return note;
    }

    public static String realPlay(String song, int playT, int musicLen){
        StringBuilder realPlay= new StringBuilder(song);
        realPlay.append(song.repeat(playT/musicLen));
        realPlay.setLength(playT);
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