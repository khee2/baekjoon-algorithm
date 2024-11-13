class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while (chicken >= 10){
            int newChicken = (chicken / 10) * 1; // 새로 받은 치킨쿠폰 수
            answer += newChicken;
            chicken = newChicken + (chicken % 10); // 새로 받은 치킨쿠폰 수 + 남은 쿠폰 수
        }        
        return answer;
    }
}