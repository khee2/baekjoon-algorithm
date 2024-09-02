MOD = 1000000009

# 최대 10000까지 미리 계산
dp = [[0]*3 for _ in range(100001)]

# n=1~3 초기값 설정
dp[1][0] = 1  
dp[2][1] = 1  
dp[3][0] = 1  
dp[3][1] = 1 
dp[3][2] = 1  

# n=4부터 점화식 
for i in range(4, 100001):
    dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % MOD
    dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % MOD
    dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % MOD

num = int(input())
for i in range(num):
    n = int(input())
    print((dp[n][0] + dp[n][1] + dp[n][2]) % MOD)
