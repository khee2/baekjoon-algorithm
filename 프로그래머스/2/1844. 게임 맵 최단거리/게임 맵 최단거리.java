import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 현재 행, 현재 열, 이동 거리
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            // 상대 있는 곳에 도달했다면 거리 반환https://school.programmers.co.kr/learn/courses/30/lessons/1844#
            if (x == n-1 && y == m-1) return dist;
            
            // 네 방향 탐색
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                // 맵 범위 내에서 이동 가능하고, 이동한 그 자리의 값이 1인 경우 
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny, dist+1});
                    maps[nx][ny] = 0; // 방문 처리해주기
                }
            }
        }
        
        return -1; // 상대 있는 곳에 도달못함
    }
}