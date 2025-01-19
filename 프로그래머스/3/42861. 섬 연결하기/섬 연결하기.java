import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // 비용 기준으로 간선 정렬
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        // 초기화: 각 노드는 자기 자신을 부모로 설정
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int edgesUsed = 0;

        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int bridgeCost = cost[2];

            // 부모가 같다는 건 두 섬이 이미 연결되어 있다는 것이므로 스킵
            // 즉, 사이클이 생기지 않으면 연결
            if (findParent(parent, island1) != findParent(parent, island2)) {
                unionParent(parent, island1, island2);
                answer += bridgeCost;
                edgesUsed++;
                
                // 모든 섬이 연결되었으면 종료
                if (edgesUsed == n-1) {
                    break;
                }
            }
        }

        return answer;
    }

    // 부모 노드 찾기
    private int findParent(int[] parent, int node) {
        if (parent[node] == node) return node; // 자신을 가리키므로 부모 노드
        return findParent(parent, parent[node]); // 경로 압축
    }

    // 두 노드를 하나의 부모를 바라보도록 합치기
    private void unionParent(int[] parent, int node1, int node2) {
        int root1 = findParent(parent, node1);
        int root2 = findParent(parent, node2);
        if (root1 < root2) {
            parent[root2] = root1;
        }
        else {
            parent[root1] = root2;
        }
    }
}
