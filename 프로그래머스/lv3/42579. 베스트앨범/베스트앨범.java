import java.util.*;
class Solution {
     public static int[] solution(String[] genres, int[] plays) {
        // 인덱스와 플레이 수를 매핑한 맵 생성
        Map<Integer, Integer> playMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            playMap.put(i, plays[i]);
        }
        // 맵을 플레이 수에 따라 내림차순 정렬
        List<Map.Entry<Integer, Integer>> playList = new ArrayList<>(playMap.entrySet());
        playList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
         // 정렬된 인덱스를 orders 배열에 저장
        int[] orders = new int[plays.length];
        for (int i = 0; i < playList.size(); i++) {
            orders[i] = playList.get(i).getKey();
        }
         
        // orders 배열에 담긴 인덱스와 동일하게 genre 정렬
        String[] sortGenres = new String[genres.length];
        for (int i = 0; i < sortGenres.length; i++) {
            sortGenres[i] = genres[orders[i]];
        }
         
        // 장르별 총합 재생횟수 맵에 저장
        Map<String, Integer> genreplay = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreplay.put(genres[i], genreplay.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 많은 순으로 정렬 후, 장르순서대로 리스트에 저장
        List<Map.Entry<String, Integer>> best = new ArrayList<>(genreplay.entrySet());
        best.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<String> most = new ArrayList<>();
        for (Map.Entry<String, Integer> aa : best) {
            most.add(aa.getKey());
        }
        // most를 기준으로, 장르별 최대 재생힛수 인덱스 순서대로 저장. 2개까지만(?)
        //장르에 속한 곡이 하나일 경우?
        Map<String, Integer> genrecnt = new HashMap<>();
        for (String genre : genres){
            genrecnt.put(genre, genrecnt.getOrDefault(genre,0)+1);
        }
        List<Integer> answer = new ArrayList<>();
        int idx = 0, cnt = 0;
        for (int i = 0; i < genres.length; i++) {
            if (sortGenres[i].equals(most.get(idx))) {
                answer.add(orders[i]);
                cnt++;
            }
            if (genrecnt.get(most.get(idx))==1){
                if(cnt == 1) {cnt = 0; idx++; i=-1;}
            }
            else{if(cnt == 2) {cnt = 0; idx++; i=-1;}}
            if (idx ==most.size()){break;}
            }
         
        // List<Integer> answers to int[] answer
        int[] answers = new int[answer.size()];
        int a = 0;
        for (int i : answer) {
            answers[a] = i;
            a++;
        }
        return answers;
    }
}