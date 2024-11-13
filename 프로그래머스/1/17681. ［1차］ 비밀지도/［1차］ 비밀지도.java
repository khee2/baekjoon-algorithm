class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++){
            // 각 줄마다 OR 연산 후 이진수 문자열로 변환
            String result = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // 이진수 문자열을 n자리로 맞추기 위해 앞에 0을 추가
            result = String.format("%" + n + "s", result).replace(' ', '0');
            
            // 이진수를 문자로 표현
            answer[i] = (result.replace("1", "#")).replace("0", " ");
            
        }
        return answer;
    }
}