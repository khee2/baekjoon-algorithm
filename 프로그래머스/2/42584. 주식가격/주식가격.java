import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>(); // 주가가 아직 떨어지지 않은 인덱스를 저장하는 스택
        int i=0;
        int[] terms = new int[prices.length]; // 결과 배열: prices[i]가 떨어질 때까지 걸린 시간 저장

        beginIdxs.push(i);
        
        // 모든 가격을 순회하며 가격이 떨어지는 순간을 찾음
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) { 
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        // 마지막까지 가격이 떨어지지 않은 값 처리
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1; 
        }

        return terms;
    }
}