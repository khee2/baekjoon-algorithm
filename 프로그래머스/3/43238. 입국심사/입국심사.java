import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long low = 1; // 최소 시간 (가장 빠른 심사관 * 1명)
        long high = (long) times[times.length - 1] * n; // 최대 시간 (가장 느린 심사관 * n명)
        long answer = high;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for (int time : times) {
                count += mid / time; // 각 심사관이 mid시간 동안 몇 명을 심사할 수 있는지
                if (count >= n) break; 
            }
            
            if (count >= n) {
                answer = mid; 
                high = mid - 1; // 더 작은 값 탐색 
            } else {
                low = mid + 1; // 더 큰 값 선택
            }
        }
        
        return answer;
    }
}