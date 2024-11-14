import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            // 일단 새로운 값을 넣고 정렬
            list.add(score[i]);
            Collections.sort(list);
            
            // 현재 크기가 k순위를 초과한다면 (k+1순위라면)
            if (list.size() > k){
                // k+1 순위에서 최소값을 제거 (현재값이든 새로운값이든 상관없이)
                list.remove(0);
            }
            // k순위에서 최소값을 제거
            answer[i] = list.get(0);
        }      
        return answer;
    }
}