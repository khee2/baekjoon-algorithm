import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;
        
        for (int truck : truck_weights) {
            while (true) {
                // 1. 큐가 비어있는 경우
                if (queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                } 
                
                // 2. 큐가 다리 길이만큼 가득 찬 경우
                else if (queue.size() == bridge_length) { 
                    sum -= queue.poll();
                } 
                
                // 3. 큐가 다리 길이만큼 가득 차지 않은 경우
                else {
                    // weight를 넘지 않는 선에서 큐에 새로운 트럭을 올리기
                    if(sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        
        return time + bridge_length;
    }
}