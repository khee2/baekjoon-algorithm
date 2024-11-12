import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0 ; i < numbers.length; i++){
            for (int j=i+1 ; j < numbers.length; j++){
                int s = numbers[i]+numbers[j];
                if (list.indexOf(s) < 0){ // 두 수의 합이 존재하지 않는다면
                    list.add(s);
                }
            }
        }
        // list를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i=0 ; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}