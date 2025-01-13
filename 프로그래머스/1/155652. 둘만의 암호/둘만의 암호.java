class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            for (int j = 0; j < index; ) { // index만큼 반복, skip일 경우 j 증가 안 함
                currentChar += 1;
                if (currentChar > 'z') {
                    currentChar -= 26; // z를 넘어가면 다시 a로 순환
                }
                if (!skip.contains(String.valueOf(currentChar))) {
                    j++; // skip에 포함되지 않은 경우에만 j 증가
                }
            }
            answer += currentChar; // 변환된 문자 추가
        }
        return answer;
    }
}
