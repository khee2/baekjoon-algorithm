import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 옷 종류별로 개수 저장하기
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1); 
        }
        
        // 조합 계산
        for (int count : map.values()) {
            answer *= (count + 1); 
        }
        
        // 한 개의 의상도 입지 않는 경우 제외
        return answer - 1;
    }
}