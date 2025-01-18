import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스

        while (left <= right) {
            // 두 사람을 한 보트에 태울 수 있는 경우
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // 가장 무거운 사람을 태우는 경우
            right--;

            // 보트 하나 증가
            answer++;
        }

        return answer;
    }
}