class Solution {
    public int solution(String dartResult) {
        int totalScore = 0; // 세 번의 다트 게임의 총합
        int[] scores = new int[3]; // 세 번의 다트 게임 점수를 각각 저장

        int currentScore = 0; 
        int roundIndex = 0; // 세 번의 다트 게임을 구분하기 위한 인덱스
        StringBuilder scoreBuilder = new StringBuilder(); 

        for (int i = 0; i < dartResult.length(); i++) {
            char currentChar = dartResult.charAt(i);

            // 점수일 때
            if (Character.isDigit(currentChar)) {
                scoreBuilder.append(currentChar);
            }

            // 보너스일 때
            else if (currentChar == 'S' || currentChar == 'D' || currentChar == 'T') {
                currentScore = Integer.parseInt(scoreBuilder.toString());
                if (currentChar == 'S') {
                    scores[roundIndex++] = (int) Math.pow(currentScore, 1);
                } else if (currentChar == 'D') {
                    scores[roundIndex++] = (int) Math.pow(currentScore, 2);
                } else { // 'T'
                    scores[roundIndex++] = (int) Math.pow(currentScore, 3);
                }
                scoreBuilder.setLength(0); // 매 라운드마다 문자열 초기화
            }

            // 옵션일 때
            else {
                if (currentChar == '*') {
                    scores[roundIndex - 1] *= 2; // 현재 라운드 점수를 2배
                    if (roundIndex - 2 >= 0) {
                        scores[roundIndex - 2] *= 2; // 이전 라운드가 존재하면 2배
                    }
                } else if (currentChar == '#') {
                    scores[roundIndex - 1] *= -1; // 현재 라운드 점수를 -1배
                }
            }
        }

        totalScore = scores[0] + scores[1] + scores[2];
        return totalScore;
    }
}