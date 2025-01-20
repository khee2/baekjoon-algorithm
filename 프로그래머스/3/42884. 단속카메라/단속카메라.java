import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 설치해야 하는 카메라 개수
        int answer = 0; 
        int len = routes.length;
        
        // 출구 지점을 기준으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        
        // 마지막 설치한 카메라 위치
        int lastCamera = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            int entrance = route[0];
            int exit = route[1];
            
            // 현재 차량 경로가 마지막 카메라로 커버되지 않는 경우
            if (lastCamera < entrance) {
                // 출구 지점에 카메라 설치
                lastCamera = exit;
                answer++;
            }   
        }
        
        return answer;
    }
}