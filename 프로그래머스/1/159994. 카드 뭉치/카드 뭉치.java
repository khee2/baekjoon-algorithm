class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int p = 0;
        int q = 0;

        for (int i = 0; i < goal.length; i++) {
            if (p < cards1.length && goal[i].equals(cards1[p])) {
                p++;
            } else if (q < cards2.length && goal[i].equals(cards2[q])) {
                q++;
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}