import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numbers[i] + "";
        }
        
        // 두 수를 앞뒤로 붙였을 때 더 큰 순서대로 정렬
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // "0"이 여러 개 있는 경우 "0"만 리턴
        if (nums[0].equals("0")) {
            return "0";
        }

        // 문자열을 이어붙이기
        StringBuilder result = new StringBuilder();
        for (String num : nums) {
            result.append(num);
        }

        return result.toString();
    }
}