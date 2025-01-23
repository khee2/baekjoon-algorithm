import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (String k : keymap) {
            for (int i = 0; i < k.length(); i++) {
                char c = k.charAt(i);
                
                // 더 가까운 인덱스 거리를 저장
                map.put(c, Math.min(i + 1, map.getOrDefault(c, Integer.MAX_VALUE))); 
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int total = 0;
            for (char t : target.toCharArray()) {
                if (map.containsKey(t)){
                    total += map.get(t);
                } else {
                    total = -1;
                    break;
                }
            }
            answer[i] = total;
        }
        
        return answer;
    }
}