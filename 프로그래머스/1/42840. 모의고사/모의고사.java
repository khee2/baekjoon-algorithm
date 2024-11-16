import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) score[0]++;
            if (answers[i] == pattern2[i % pattern2.length]) score[1]++;
            if (answers[i] == pattern3[i % pattern3.length]) score[2]++;
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        // 최댓값을 가진 사람의 수 카운트
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) count++;
        }
        
        // 결과 배열에 최댓값을 가진 사람 번호 저장
        int[] answer = new int[count];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                answer[index++] = i + 1;
            }
        }
        return answer;
    }
}