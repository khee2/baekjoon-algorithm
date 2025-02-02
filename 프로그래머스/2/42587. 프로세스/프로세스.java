import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 큐에 인덱스, 중요도 저장
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
            priorityQueue.add(priorities[i]);
        }
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            // 현재 프로세스 하나 꺼내기 
            int[] current = queue.poll();
            // 현재 프로세스의 중요도가 가장 높은 중요도와 같은지 확인
            if (current[1] == priorityQueue.peek()) {
                priorityQueue.poll();
                answer++;
                if (current[0] == location) {
                    return answer;
                }
                
            } else {  // 우선순위가 낮으면 다시 큐에 넣기
                queue.add(current);
            }
        }
    
        return -1;
    }
}