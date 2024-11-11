import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){ 
                // 앞에 나온 문자가 아니라면 -1 저장
                answer[i] = -1;
            } else {
                // 앞에 나온 문자라면 i-이전문자인덱스 를 저장
                answer[i] = i - map.get(s.charAt(i));
            }
            // 자신과 가까운 동일 문자를 찾아야 하므로, 모든 값을 저장 
            map.put(s.charAt(i), i);
        }
        return answer;
    }
}