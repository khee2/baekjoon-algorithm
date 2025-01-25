import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 1. 장르별 총 재생 횟수 구하기
        Map<String, Integer> genrePlayCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 2. 장르 내 노래 재생 횟수, 인덱스 정보 저장하기
        Map<String, List<int[]>> genreToSongs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreToSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreToSongs.get(genres[i]).add(new int[] {i, plays[i]});
        }
        
        // 3. 장르 정렬
        List<String> sortedGenres = genrePlayCount.keySet().stream()
            .sorted((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1))
            .collect(Collectors.toList()); 
        
        // 4. 장르별 노래 정렬
        for (String genre : genreToSongs.keySet()) {
            List<int[]> songs = genreToSongs.get(genre);
            songs.sort((s1, s2) -> s2[1] == s1[1] ? s1[0] - s2[0] : s2[1] - s1[1]);
        }
        
        // 5. 총 재생 횟수가 많은 장르부터 해당 장르 내에서 재생 횟수가 높은 노래 순으로 처리
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreToSongs.get(genre);
            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i)[0]);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}