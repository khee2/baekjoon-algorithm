import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // [0, 1, 3, 5, 6]
        int n = citations.length;
        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            int count = citations[i];
            int least = n - i; // h편 이상
        
            if (least >  count) { // h번 이상 논문이 인용되었다면 
                hIndex = Math.max(hIndex, count);
            } else {
                hIndex = Math.max(hIndex, least);
            }
        }
        return hIndex;
    }
}
