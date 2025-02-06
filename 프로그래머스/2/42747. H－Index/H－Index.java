import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex = citations.length;

        for (int citation : citations) {
            if (citation >= hIndex) {
                return hIndex;
            }
            hIndex--;
        }
        return 0;
    }
}