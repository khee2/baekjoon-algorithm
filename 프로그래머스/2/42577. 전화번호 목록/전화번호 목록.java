import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        // 각 전화번호의 접두사가 HashSet에 있는지 확인
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i); // 접두사 생성
                if (set.contains(prefix)) {
                    return false; // 접두사가 발견되면 false 반환
                }
            }
        }
        
        return true; // 접두사가 없으면 true 반환
    }
}