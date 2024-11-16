import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        // 약수 구하기
        for (int i = 1; i<= number; i++){
            int count = 0;
            for (int j = 1; j*j <= i ; j++){
                if (j*j == i) {count++;}
                else if ((i % j) == 0) {count+=2;}
            }
            list.add(count);
        }
        
        // 공격력 제한수치를 넘는다면 power로 대체
        for (int i=0; i < list.size(); i++){
            if (list.get(i) > limit){
                answer += power;
            } else{
                answer += list.get(i);
            }
        }
        return answer;
    }
}