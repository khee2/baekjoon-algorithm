class Solution {
    public String solution(int[] food) {
        String answer = "";
        for (int i = 1; i < food.length; i++){
            int count = food[i] / 2;
            for (int j = 0; j < count; j++){
                answer += i;
            }
        }
        StringBuffer r = new StringBuffer(answer);
        return answer + "0" + r.reverse().toString();
    }
}