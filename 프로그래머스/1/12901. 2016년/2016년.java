class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] d = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dotw = {"THU","FRI","SAT", "SUN", "MON", "TUE", "WED"};
        int d_sum = 0;
        for (int i = 0; i < a-1; i++){
            d_sum += d[i];
        }
        d_sum += b;
        for (int i = 0; i < 7; i++){
            if (((d_sum - i) % 7) == 0){
                answer = dotw[i];
            }
        }          
        return answer;
    }
}