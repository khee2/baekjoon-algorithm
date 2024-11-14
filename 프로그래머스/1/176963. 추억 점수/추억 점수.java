import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        List<String> list = Arrays.asList(name);
        for (int i = 0; i < photo.length; i++){
            int s = 0;
            for (int j = 0; j < photo[i].length; j++){
                int index = list.indexOf(photo[i][j]);
                if (index != -1) { // 이름이 리스트에 존재할 때만 값을 더함
                    s += yearning[index];
                }
            }
            answer[i] = s;
        }
        return answer;
    }
}