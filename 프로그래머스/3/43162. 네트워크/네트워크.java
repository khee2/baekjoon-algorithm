class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 방문 여부 체크
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문하지 않은 노드라면 새로운 네트워크 발견
                dfs(i, computers, visited);
                answer++; // 네트워크 개수 증가
            }
        }

        return answer;
    }

    private void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) { // 연결된 노드이면서 방문하지 않은 경우
                dfs(i, computers, visited);
            }
        }
    }
}
