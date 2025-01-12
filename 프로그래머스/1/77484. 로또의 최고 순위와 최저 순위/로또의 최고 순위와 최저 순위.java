import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 당첨 번호를 Set으로 변환
        Set<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }

        int matched = 0; // 일치하는 번호 개수
        int zeroCount = 0; // 0의 개수

        // lottos 배열 탐색
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (winSet.contains(num)) {
                matched++;
            }
        }

        // 최고 순위: 일치하는 번호 + 0의 개수
        int maxRank = getRank(matched + zeroCount);
        // 최저 순위: 일치하는 번호만
        int minRank = getRank(matched);

        return new int[]{maxRank, minRank};
    }

    // 맞춘 개수를 바탕으로 순위를 계산하는 메서드
    private int getRank(int matchCount) {
        switch (matchCount) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}
