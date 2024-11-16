import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) answer[0]++;
            if (answers[i] == pattern2[i % pattern2.length]) answer[1]++;
            if (answers[i] == pattern3[i % pattern3.length]) answer[2]++;
        }
        
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        
        ArrayList<Integer> winners = new ArrayList<>();
        for (int i = 0 ; i < 3 ; i++){
            if (answer[i] == max) winners.add(i+1);
        }
        return winners.stream().mapToInt(i -> i).toArray();
    }
}