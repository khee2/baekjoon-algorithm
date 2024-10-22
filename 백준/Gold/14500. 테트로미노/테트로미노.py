# 상, 하, 좌, 우
move = [(0, 1), (0, -1), (1, 0), (-1, 0)]

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

# dfs에서는 visited를 둬서 방문 여부를 확인하고, dfs가 끝나면 방문해제를 해준다. 
visited = [[False] * M for _ in range(N)]

# 최대 합을 저장할 변수
max_sum = 0

# ㅗ, ㅜ, ㅓ, ㅏ 제외한 모양들 최대값 계산
# dfs를 통해 현재 좌표 i, j에서 시작해, 총 4칸(정사각형)까지 이동하면서 테트로미노 모양을 완성하고, 그때의 값(dsum)을 이용해 최댓값을 갱신
def dfs(i, j, dsum, cnt):
    global max_sum
    # 모양이 완성되었을 때 최대값 계산
    if cnt == 4:
        max_sum = max(max_sum, dsum)
        return

    # 상, 하, 좌, 우로 이동
    for n in range(4):
        ni = i + move[n][0]
        nj = j + move[n][1]
        if 0 <= ni < N and 0 <= nj < M and not visited[ni][nj]:
            # 방문 표시 및 방문 해제
            visited[ni][nj] = True
            dfs(ni, nj, dsum + board[ni][nj], cnt + 1)
            visited[ni][nj] = False

# ㅗ, ㅜ, ㅓ, ㅏ 모양의 최대값 계산
def dfs_other(i, j):
    global max_sum
    # ㅗ의 4가지 방향 
    for n in range(4):
        # tmp에 중앙값 저장
        tmp = board[i][j]
        for k in range(3):
            # move 배열의 요소를 3개씩 사용할 수 있도록 인덱스 계산
            t = (n + k) % 4
            ni = i + move[t][0]
            nj = j + move[t][1]

            if not (0 <= ni < N and 0 <= nj < M):
                tmp = 0
                break
            # 유효한 3칸을 더한 합을 tmp에 저장 
            tmp += board[ni][nj]
        # 최대값 계산
        max_sum = max(max_sum, tmp)

# 메인 로직
for i in range(N):
    for j in range(M):
        # ㅗ, ㅜ, ㅓ, ㅏ 모양 제외 탐색
        visited[i][j] = True
        dfs(i, j, board[i][j], 1)
        visited[i][j] = False

        # ㅗ, ㅜ, ㅓ, ㅏ 모양 탐색
        dfs_other(i, j)

# 결과 출력
print(max_sum)