import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int length = number.length();
        
        for (int i = 0; i < length; i++){
            char current = number.charAt(i);
            
            // 스택 맨 위 숫자보다 현재 새로 들어오려고 하는 숫자가 크면 기존 숫자 제거
            while (!stack.isEmpty() && stack.peek() < current && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }
        
        // 제거할 숫자가 남아있는 경우 맨 위에서부터 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder answer = new StringBuilder();
        for (char c : stack) answer.append(c);
        
        return answer.toString();
    }
}