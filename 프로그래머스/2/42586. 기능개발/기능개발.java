import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> remainingDays = new LinkedList<>();
        
        // 배포까지 남은 일수 저장 
        for (int i = 0; i < progresses.length; i++) {
            int remaining = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            remainingDays.offer(remaining);
        }
        
        List<Integer> deploymentCounts = new ArrayList<>();
        
        // 뒤에 있는 기능이 앞에 있는 기능보다 더 빨리 개발되는 경우 +1
        while (!remainingDays.isEmpty()) {
            int count = 1;
            int deployDay = remainingDays.poll();
            
            while (!remainingDays.isEmpty() && deployDay >= remainingDays.peek()) {
                remainingDays.poll();
                count++;
            }
            deploymentCounts.add(count);
        }
        
        return deploymentCounts.stream().mapToInt(i -> i).toArray();
    }
}