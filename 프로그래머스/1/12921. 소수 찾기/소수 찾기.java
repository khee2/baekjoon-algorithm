class Solution {
    public int solution(int n) {
        int answer = 0; 
        for (int i = 2; i <= n; i++) { 
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) { // i의 제곱근까지만 확인
                if (i % j == 0) { // 나누어떨어지면 소수가 아님
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) { // 소수라면 answer 증가
                answer++;
            }
        }
        return answer;
    }
}