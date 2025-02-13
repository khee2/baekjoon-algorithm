import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length, answer = 0;

        // 1. 빈 공간(0)과 퍼즐 조각(1) 리스트 생성
        List<List<int[]>> spaces = getShapes(game_board, 0);
        List<List<int[]>> pieces = getShapes(table, 1);
        
        // 2. 사용된 퍼즐 조각 체크
        boolean[] used = new boolean[pieces.size()];

        // 3. 빈 공간을 하나씩 채울 수 있는 퍼즐 조각 찾기
        for (List<int[]> space : spaces) {
            for (int i = 0; i < pieces.size(); i++) {
                if (!used[i] && canFit(space, pieces.get(i))) {
                    answer += space.size(); // 맞춰진 칸 개수 추가
                    used[i] = true;
                    break;
                }
            }
        }

        return answer; 
    }

    // 빈 공간 및 퍼즐 조각 찾기
    private List<List<int[]>> getShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    shapes.add(bfs(board, visited, i, j, target));
                }
            }
        }
        return shapes;
    }

    // BFS를 사용해서 연결된 블록 찾기
    private List<int[]> bfs(int[][] board, boolean[][] visited, int x, int y, int target) {
        List<int[]> shape = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            shape.add(new int[]{pos[0] - x, pos[1] - y}); // 기준점 (0,0)으로 변환
            
            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d], ny = pos[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length && 
                    board[nx][ny] == target && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return normalize(shape);
    }

    // 퍼즐 조각이 빈 공간에 맞는지 확인
    private boolean canFit(List<int[]> space, List<int[]> piece) {
        if (space.size() != piece.size()) return false;

        // 90도씩 회전하며 비교
        for (int r = 0; r < 4; r++) {
            piece = rotate(piece);
            if (matches(space, piece)) return true;
        }
        return false;
    }

    // 퍼즐 조각 90도 회전
    private List<int[]> rotate(List<int[]> piece) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : piece) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        return normalize(rotated);
    }

    // 좌표를 정규화하여 0,0 기준으로 변환
    private List<int[]> normalize(List<int[]> piece) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : piece) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        List<int[]> normalized = new ArrayList<>();
        
        for (int[] p : piece) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY});
        }

        // 정렬하여 형태를 일정하게 유지
        normalized.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return normalized;
    }

    // 두 개의 블록이 동일한지 확인
    private boolean matches(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
            // if (!Arrays.equals(a.get(i), b.get(i))) return false; // 이것도 가능
        }
        return true;
    }
}
