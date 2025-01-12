class Solution {
    public int solution(String s) {
        int answer = 0; // 분해한 문자열 개수
        int i = 0; // 문자열을 읽을 위치

        while (i < s.length()){
            char x = s.charAt(i);
            int x_count = 0; // x 개수
            int other_count = 0; // x가 아닌 개수
            
            while (i < s.length()){
                if (s.charAt(i) == x) x_count++;
                else other_count++;
                i++;
                
                if (x_count == other_count) break;
            }
            answer++; // 부분 문자열 개수 증가
            // 바깥 while문은 남은 부분부터 시작 
        }
        return answer;
    }
}