import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        // 중복 제거
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i=1; i< arr.length; i++){
            stack.push(arr[i]);
            if (arr[i-1] == arr[i]) {
                stack.pop();
            }
        }
        
        // 스택을 배열로 변환
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}