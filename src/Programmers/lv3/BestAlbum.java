package Programmers.lv3;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "Newage", "pop", "classic", "classic", "pop", "Newage"};
        int[] plays = {500, 1700, 600, 150, 800, 2500, 1500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<Integer, Integer> playMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            playMap.put(i, plays[i]);
        }
        List<Map.Entry<Integer, Integer>> playList = new ArrayList<>(playMap.entrySet());
        playList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); // 맵을 플레이 수에 따라 내림차순 정렬

        int[] orders = new int[plays.length]; // 정렬된 인덱스를 orders 배열에 저장
        for (int i = 0; i < playList.size(); i++) {
            orders[i] = playList.get(i).getKey();
        }

        String[] sortGenres = new String[genres.length]; // orders배열에 담긴 인덱스와 동일하게 genre 정렬
        for (int i = 0; i < sortGenres.length; i++) {
            sortGenres[i] = genres[orders[i]];
        }

        Map<String, Integer> genreplay = new HashMap<>(); // 장르별 총합 재생횟수 맵에 저장
        for (int i = 0; i < genres.length; i++) {
            genreplay.put(genres[i], genreplay.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> best = new ArrayList<>(genreplay.entrySet()); // 내림차순 정렬 후, 장르순서대로 리스트에 저장
        best.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<String> most = new ArrayList<>();   //  장르별 재생횟수 총합이 가장 많은 장르부터 나옴.
        for (Map.Entry<String, Integer> aa : best) {
            most.add(aa.getKey());
        }

        Map<String, Integer> genrecnt = new HashMap<>(); //장르별 노래 갯수
        for (String genre : genres){
            genrecnt.put(genre, genrecnt.getOrDefault(genre,0)+1);
        }

        List<Integer> answer = new ArrayList<>(); //정렬한 장르별 재생횟수 총합을 기준으로, 장르별 최대 재생힛수 인덱스 순서대로 저장.
        int idx = 0, cnt = 0;
        for (int i = 0; i < genres.length; i++) {
            if (sortGenres[i].equals(most.get(idx))) {
                answer.add(orders[i]); cnt++;
            }
            if (genrecnt.get(most.get(idx))==1){
                if(cnt == 1) {cnt = 0; idx++; i=-1;}
            }
            else{if(cnt == 2) {cnt = 0; idx++; i=-1;}}
            if (idx ==most.size()){break;}
            }

        int[] answers = new int[answer.size()]; // List<Integer> answers to int[] answer
        int a = 0;
        for (int i : answer) {
            answers[a++] = i;
        }
        return answers;
    }
}
// 수도
//        맵에 저장, 밸류는 인덱스
//        plays 값 역순 정렬 후 인덱스 재조정
//        맵 값에 따라 genres 수정
//        재생횟수 가장 많은 장르순으로 맵 정렬
//        배열에 징르 별로 앞에서부터(역순 정렬 된 상태) 두개 씩 저장