import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> beginIdxs = new ArrayDeque<>(); // 주가가 아직 떨어지지 않은 인덱스를 저장
        int i = 0;
        int[] terms = new int[prices.length]; // prices[i]가 떨어질 때까지 걸린 시간 저장

        // 모든 가격을 순회하며 가격이 떨어지는 순간을 찾음
        beginIdxs.push(i);
        for (i = 1; i < prices.length; i++) {
            while (!beginIdxs.isEmpty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }

		// 마지막까지 가격이 떨어지지 않은 값 처리
        while (!beginIdxs.isEmpty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
}