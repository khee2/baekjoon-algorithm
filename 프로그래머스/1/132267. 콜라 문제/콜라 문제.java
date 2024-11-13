class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a){ // 빈 병이 a개 이상일 때만 교환 가능
            int newColas = (n / a) * b; // 받을 수 있는 새로운 콜라 병 수
            answer += newColas; // 받은 콜라 병 수 누적
            n = newColas + (n % a); // 받은 콜라 병 수 + 교환 후 남은 빈 병
        }
        return answer;
    }
}