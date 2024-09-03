MOD = 1000000000

N = int(input())

dp = [[0]*10 for _ in range(N)]

# n=1 초기값 설정
dp[0] = [0,1,1,1,1,1,1,1,1,1] # 0으로 시작하는 수는 계단수가 아님

# n=2~N까지 점화식 
for n in range(1, N):
    dp[n][0]=dp[n-1][1] # 끝자리가 0
    dp[n][9]=dp[n-1][8] # 끝자리가 9
    for m in range(1, 9): # 끝자리가 1~8
        dp[n][m]= dp[n-1][m-1] + dp[n-1][m+1]

print(sum(dp[N-1]) % MOD)