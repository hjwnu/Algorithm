import java.util.*;

class Solution {

    static class State {
        int idx;
        Set<Integer> chosen;
        State(int idx, Set<Integer> chosen) {
            this.idx = idx;
            this.chosen = chosen;
        }
    }

    public int solution(String[] user_id, String[] banned_id) {

        List<List<Integer>> candidates = new ArrayList<>();
        for (String ban : banned_id) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < user_id.length; i++) {
                if (match(user_id[i], ban)) list.add(i);
            }
            candidates.add(list);
        }

        Queue<State> q = new ArrayDeque<>();
        q.add(new State(0, new HashSet<>()));

        Set<String> results = new HashSet<>();

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.idx == banned_id.length) {
                results.add(toKey(cur.chosen));
                continue;
            }

            for (int userIdx : candidates.get(cur.idx)) {
                if (cur.chosen.contains(userIdx)) continue;

                Set<Integer> nextChosen = new HashSet<>(cur.chosen);
                nextChosen.add(userIdx);

                q.add(new State(cur.idx + 1, nextChosen));
            }
        }

        return results.size();
    }

    private boolean match(String user, String ban) {
        if (user.length() != ban.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            char bc = ban.charAt(i);
            if (bc == '*') continue;
            if (user.charAt(i) != bc) return false;
        }
        return true;
    }

    private String toKey(Set<Integer> chosen) {
        List<Integer> list = new ArrayList<>(chosen);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int x : list) sb.append(x).append(',');
        return sb.toString();
    }
}
