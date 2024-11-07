class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // 마지막으로 등장한 문자 위치 기록
        int[] lastSeen = new int[26]; 
        
        java.util.Arrays.fill(lastSeen, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charIndex = c - 'a'; 
            
            if (lastSeen[charIndex] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - lastSeen[charIndex];
            }
            
            // 해당 문자 마지막 위치 갱신
            lastSeen[charIndex] = i;
        }
        
        return answer;
    }
}