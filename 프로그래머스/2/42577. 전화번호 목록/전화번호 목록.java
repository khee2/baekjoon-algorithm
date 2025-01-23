import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호를 사전순으로 정렬
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            // 현재 번호가 다른 번호의 접두어인 경우 false 반환
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false; 
            }
        }
        
        return true; // 접두사 관계가 없는 경우 true 반환
    }
}