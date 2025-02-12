import java.util.*;

class Solution {
    public List<String> solution(String[][] tickets) {
        // 그래프 생성
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        
        // 방문 경로 저장할 리스트 
        LinkedList<String> route = new  LinkedList<>();
        dfs("ICN", graph, route);
        
        return route;
    }
    
    private void dfs (String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> route) {
        PriorityQueue<String> des = graph.get(airport);
        // 모든 경로 방문
        while (des != null && !des.isEmpty()) {
            dfs(des.poll(), graph, route); // 알파벳 순으로 방문
        }
        route.addFirst(airport); // 역순으로 추가
    }
}