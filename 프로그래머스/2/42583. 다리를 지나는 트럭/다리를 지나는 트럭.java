import java.util.*;
class Solution {
      static int time = 0;
    static List<Integer> times = new ArrayList<>();
    static int bridgeWeight = 0;
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> waitTrucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for (int truck : truckWeights) {
            waitTrucks.add(truck);
        }
        while(!waitTrucks.isEmpty()){
            if(bridgeWeight + waitTrucks.peek() <= weight
                    && bridge.size() < bridgeLength){
                bridge.add(waitTrucks.peek());
                bridgeWeight += waitTrucks.poll();
                times.add(0);
            }
            acrossTheBridge(bridgeLength, bridge); time++;
        }
        if(!bridge.isEmpty()){
            time += bridgeLength;
        }
        return time;
    }

    public static void acrossTheBridge(int bridgeLength, Queue<Integer> bridge){
        for(int i =0; i < times.size();i++){
            times.set(i, times.get(i) + 1);
            if(times.get(i)==bridgeLength){
                bridgeWeight -= bridge.poll();
            }
        }
    }
}