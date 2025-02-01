import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>(); 
        for (char c : s.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '(') { 
                stack.push(c);
            } else {
                answer = false;
                break;
            }
        }
        // 스택이 비어있는지 체크 (모든 괄호가 짝을 이뤘는지)
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}