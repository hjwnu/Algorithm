import java.util.HashMap;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a").replace("G#", "g");
        HashMap<String, Object> found = new HashMap<>();
        found.put("time", 0);
        found.put("name", "(None)");

        for (String data : musicinfos) {
            String[] splitData = data.split(",");
            String start = splitData[0];
            String end = splitData[1];
            String name = splitData[2];
            String song = splitData[3];

            String[] startTokens = start.split(":");
            int startHour = Integer.parseInt(startTokens[0]);
            int startMin = Integer.parseInt(startTokens[1]);

            String[] endTokens = end.split(":");
            int endHour = Integer.parseInt(endTokens[0]);
            int endMin = Integer.parseInt(endTokens[1]);

            int length = (endHour - startHour) * 60 + (endMin - startMin);

            song = song.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a").replace("G#", "g");
            StringBuilder repeatedSong = new StringBuilder();
            for (int i = 0; i < length / song.length() + 1; i++) {
                repeatedSong.append(song);
            }
            song = repeatedSong.substring(0, length);

            if (song.contains(m) && (int)found.get("time") < length) {
                found.put("time", length);
                found.put("name", name);
            }
        }

        return String.valueOf(found.get("name"));
    }
}