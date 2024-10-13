MOD = 1_000_000_000

def solve(N, K):
    # DP 배열 초기화 
    dp = [[0] * (N + 1) for _ in range(K + 1)]
    
    # 초기값
    for i in range(N + 1):
        dp[1][i] = 1
    
    # DP 테이블 채우기
    for i in range(2, K + 1):  # 정수 개수 2부터 K까지
        for j in range(N + 1):  # 합 0부터 N까지
            for l in range(j + 1):  # 현재 합에 사용할 숫자 l
                dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD

    return dp[K][N]

N, K = map(int, input().split())
print(solve(N, K))