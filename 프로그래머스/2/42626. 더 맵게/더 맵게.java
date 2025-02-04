import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int s : scoville) {
            minHeap.offer(s);
        }

        int mixCount = 0;
        
        while (minHeap.size() > 1) {
            if (minHeap.peek() >= K) {
                return mixCount;
            }

            int first = minHeap.poll();
            int second = minHeap.poll();

            int newFood = first + (second * 2);
            minHeap.offer(newFood);
            mixCount++;
        }

        // 마지막 하나가 K 이상인지 확인
        return minHeap.peek() >= K ? mixCount : -1;
    }
}
