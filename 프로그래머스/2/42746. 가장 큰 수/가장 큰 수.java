import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);

        // 두 수를 앞뒤로 붙였을 때 더 큰 순서대로 정렬
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // "0"이 여러 개 있는 경우 "0"만 리턴
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        return String.join("", strNumbers);
    }
}
