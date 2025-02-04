import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> (Integer.compare(a[0], b[0])));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int time = 0; // 현재 시간
        int idx = 0;
        int totalTime = 0; // 모든 작업의 반환 시간 합
        int n = jobs.length; 
        int completedJobs = 0; // 완료된 작업 개수
        
        while (completedJobs < n) {
            // 현재 시간이 작업이 요청되는 시점이라면 큐에 담기
            while (idx < n && jobs[idx][0] <= time) {
                queue.offer(jobs[idx]);
                idx++;
            }
            
            // 큐가 비어있지 않다면 큐에 담긴 작업 시작
            if (!queue.isEmpty()) {
                int[] currentJob = queue.poll();
                time += currentJob[1];
                totalTime += (time - currentJob[0]);
                completedJobs++;
            } else { // 큐가 비어있다면 요청 시간이 가장 짧은 시간으로 할당
                time = jobs[idx][0];
            }
            
        }
        
        return totalTime / n;
    }
}