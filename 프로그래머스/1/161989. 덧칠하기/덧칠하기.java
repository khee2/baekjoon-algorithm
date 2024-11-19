class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastPainted = 0; // 마지막으로 칠한 구역의 끝 위치

        for (int i = 0; i < section.length; i++) {
            // 페인트를 다시 칠해야 하는 구역이 마지막으로 칠한 구역 이후에 있다면 칠하기
            if (section[i] > lastPainted) {
                // 새로운 구역을 칠할 때는 롤러로 덮을 수 있는 구역을 최대한 덮기
                lastPainted = section[i] + m - 1;
                answer++;
            }
        }

        return answer;
    }
}