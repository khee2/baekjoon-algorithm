import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 각 숫자의 빈도를 저장할 배열
        int[] countX = new int[10];
        int[] countY = new int[10];

        // X와 Y의 각 숫자의 빈도를 계산
        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        // 공통된 숫자의 최소 개수를 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) { // 큰 숫자부터 sb에 저장
            int common = Math.min(countX[i], countY[i]);
            for (int j = 0; j < common; j++) {
                sb.append(i);
            }
        }

         // 공통 숫자가 없는 경우
        if (sb.length() == 0) {
            return "-1";
        }
        
        // 0으로만 이루어진 경우
        if (sb.toString().matches("0+")) {
            return "0"; 
        }
        
        return sb.toString(); 
    }
}