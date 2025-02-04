import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (String o : operations) {
            if (o.startsWith("I")) { // 삽입 연산
                int val = Integer.parseInt(o.substring(2));
                min.offer(val);
                max.offer(val);
            } else if (o.equals("D 1")) { // 최댓값 삭제
                if (!max.isEmpty()) {
                    int val = max.poll();
                    min.remove(val);
                }
            } else {
                if (!min.isEmpty()) { // 최솟값 삭제
                    int val = min.poll();
                    max.remove(val);
                }
            }
        }
        
        if (max.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{max.peek(), min.peek()};
    }
}