import java.util.*;

class Solution {
    static class Rect {
        int x1, x2, y1, y2;

        public Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static int x, y;
    static List<Rect> rectList;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[102][102];
        rectList = new ArrayList<>();

        // 주어진 사각형 좌표를 처리
        for (int i = 0; i < rectangle.length; i++) {
            // 사각형 좌표를 2배 크기로 변환
            int sx = rectangle[i][0] * 2;
            int sy = rectangle[i][1] * 2;
            int ex = rectangle[i][2] * 2;
            int ey = rectangle[i][3] * 2;

            // 테두리 -1로 채우기
            for (int y = sy; y <= ey; y++) {
                for (int x = sx; x <= ex; x++) {
                    map[y][x] = -1; // x는 열, y는 행
                }
            }

            // 사각형 정보 저장
            rectList.add(new Rect(sx, sy, ex, ey));
        }

        answer = bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer;
    }

    static int bfs(int[][] map, int x, int y, int tx, int ty) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        map[y][x] = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            int move = p[2];

            // 아이템에 도달하면 거리 반환 (2배 크기라서 move/2)
            if (px == tx && py == ty) {
                return move / 2;
            }

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                // 이동할 곳이 테두리이고, 바운더리 안에 있는지 확인
                if (map[ny][nx] < 0 && isBoundary(nx, ny)) {
                    map[ny][nx] = move + 1;
                    q.add(new int[]{nx, ny, move + 1});
                }
            }
        }
        return -1; 
    }

    static boolean isBoundary(int x, int y) {
        // 해당 좌표가 사각형의 내부가 아닌지 확인
        for (Rect r : rectList) {
            if (r.x1 < x && r.y1 < y && r.x2 > x && r.y2 > y) {
                return false;
            }
        }
        return true;
    }
}
