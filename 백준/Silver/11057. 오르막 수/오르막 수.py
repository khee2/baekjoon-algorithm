N = int(input())

dp = [[0] * 10 for _ in range(N+1)]

# 길이 1일 때는 모든 자리에 1씩 저장
for i in range(10):
    dp[1][i] = 1

# DP 테이블 채우기
for n in range(2, N+1):
    for i in range(10):
        dp[n][i] = sum(dp[n-1][j] for j in range(i+1)) % 10007

# 결과 계산
print(sum(dp[N]) % 10007)