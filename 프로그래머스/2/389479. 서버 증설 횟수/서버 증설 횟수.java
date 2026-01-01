import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        ServerRoom serverRoom = new ServerRoom(k);
        for (int player : players) {
            serverRoom.checkExpireServer();
            boolean isAvailable = player < m * serverRoom.size;
            while (! isAvailable) {
                serverRoom.addServer();
                isAvailable = player < m * serverRoom.size;
            }
            serverRoom.plusTime();
        }
        return serverRoom.additionLog;
    }

    static class Server {
        private int time;

        Server(){
            this.time = 0;
        }

        public void plusTime(){
            this.time++;
        }
    }

    static class ServerRoom {
        private final Queue<Server> serverList;
        private int size;
        private final int expireTime;
        private int additionLog;


        ServerRoom (int k) {
            this.serverList = new ArrayDeque<>();
            this.size = 1 ;
            this.expireTime = k;
            this.additionLog = 0;
        }

        public void addServer () {
            serverList.add(new Server());
            this.size++;
            this.additionLog++;
        }

        public void plusTime () {
            if (serverList.isEmpty()) return;
            serverList.forEach(Server::plusTime);
        }

        public void checkExpireServer () {
            if (serverList.isEmpty()) return;
            while (!serverList.isEmpty()) {
                if (serverList.peek().time != expireTime) return;
                serverList.poll();
                size--;
            }
        }
    }
}