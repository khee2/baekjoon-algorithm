import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;


class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        if (!set.contains(target)) return 0;
        return bfs(begin, target, set);
    }
    
    private int bfs(String begin, String target, Set<String> set) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        Map<String, Integer> depth = new HashMap<>();
        depth.put(begin, 0);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            int answer = depth.get(current);
            
            for (String word : set) {
                if (!depth.containsKey(word) && canTransform(current, word)) {
                    if (word.equals(target)) return answer + 1;
                    queue.offer(word);
                    depth.put(word, answer + 1);
                }
            }
        }
        
        return 0;
    }
            
    private boolean canTransform (String word1, String word2) {
        // word1과 word2가 차이나는 알파벳이 하나면 된다. 
        int count = 0;
        
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}