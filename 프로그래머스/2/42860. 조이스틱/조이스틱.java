class Solution {
    public int solution(String name) {
        int length = name.length();
        int index = 0;
        
        int spell_move = 0; // 알파벳 이동
        int cursor_move = length - 1; // 좌우 이동

        for (int i = 0 ; i < length ; i++){
            // 알파벳 이동 최적화
            // 'A'와 'Z' 중 어디서 시작했을 때 최소 이동 거리가 되는지
            spell_move += Math.min(name.charAt(i) - 'A', 'Z'- name.charAt(i) + 1);
            
            
            // 좌우 이동 최적화
            // 연속된 A 개수 세기
            index = i + 1;
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }
            
            // 순서대로 가는 것과 뒤로 돌아가는 것 중 최소 이동 거리 선택
            cursor_move = Math.min(cursor_move, i * 2 + length - index);
            
            // 처음부터 뒷부분을 먼저 입력하는 것
            cursor_move = Math.min(cursor_move, (length - index) * 2 + i);
        }
            
        return spell_move + cursor_move;
    }
}