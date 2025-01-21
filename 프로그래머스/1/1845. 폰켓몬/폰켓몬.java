import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int type = set.size(); // 폰켓몬 종류
        int select = nums.length / 2; // 골라야 하는 폰켓몬 수
        
        if(select <= type) return select;
        else return type;
    }
}