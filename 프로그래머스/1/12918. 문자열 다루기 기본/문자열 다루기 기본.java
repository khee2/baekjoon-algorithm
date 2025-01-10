class Solution {
    public boolean solution(String s) {
        int sl = s.length();
        boolean isNumeric = s.matches("\\d+");
        return (sl == 4 || sl == 6) && isNumeric;
    }
}