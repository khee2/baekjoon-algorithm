class Solution {
    public int[] solution(int[] prices) {
		int len = prices.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
		        answer[i]++;
                if (prices[i] > prices[j]) { // 가격이 떨어진다면 중단
                    break;
                }
            }
        }
        return answer;
    }
}