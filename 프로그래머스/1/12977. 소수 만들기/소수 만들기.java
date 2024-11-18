class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        // 배열에서 세 수를 선택해 소수 개수를 계산
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++){
                for (int k = j+1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    // 소수 판별 함수
    public boolean isPrime(int n) {
        if (n < 2) return false; // 1이나 0은 소수가 아님
        for (int i = 2; i * i <= n; i++) { 
            if (n % i == 0) { // 나눠지는 수가 있으면 소수가 아님
                return false;
            }
        }
        return true;
    }
}