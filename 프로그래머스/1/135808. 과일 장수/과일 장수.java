import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int s : score) {
            list.add(s);
        }
        list.sort(Comparator.reverseOrder()); // 내림차순 정렬
        
        for (int i = 0; i < score.length / m; i++) {
            // m개씩 접근하여 최소값 * m을 answer에 추가
            int minValue = list.get(i * m + m - 1); // 그룹에서 최소값은 정렬된 상태에서 끝 값
            answer += minValue * m;
        }
        return answer;
    }
}