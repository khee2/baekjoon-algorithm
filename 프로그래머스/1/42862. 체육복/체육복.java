import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {    
		int answer = 0;
		    
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        for (int l :lost) lostList.add(l);
        for (int r : reserve) reserveList.add(r);

        // 여분 체육복이 있는 학생이 도난당한 경우 reserve와 lost에서 제거
        List<Integer> common = new ArrayList<>(lostList);
        common.retainAll(reserveList); 
        lostList.removeAll(common);  
        reserveList.removeAll(common); 

        Collections.sort(reserveList);
        
        // reserve를 돌면서 본인 앞뒤 학생에게 체육복을 빌려줌
        for (int r : reserveList) {
            if (lostList.contains(r-1)) {
                lostList.remove((Integer) (r-1)); // 앞번호 학생 빌려줌
            } else if (lostList.contains(r+1)) {
                lostList.remove((Integer) (r+1)); // 뒷번호 학생 빌려줌
            }
        }

        // 총 학생 수에서 체육복이 없는 학생 수를 뺌
        answer = n - lostList.size();
        return answer;
    }
}