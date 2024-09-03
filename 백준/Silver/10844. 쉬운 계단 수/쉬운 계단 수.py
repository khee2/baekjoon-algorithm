MOD = 1000000000

# 1~100까지 미리 계산
# 사용하는 인덱스: 0~9, 1~100
dp = [[0]*11 for _ in range(101)]

# n=1 초기값 설정
dp[1][0] = 0 # 0으로 시작하는 수는 계단수가 아님
dp[1][1] = 1  
dp[1][2] = 1  
dp[1][3] = 1  
dp[1][4] = 1  
dp[1][5] = 1  
dp[1][6] = 1  
dp[1][7] = 1  
dp[1][8] = 1  
dp[1][9] = 1  


# n=4부터 점화식 
for n in range(2, 101):
    for m in range(0, 10):
        if (m==0):
            dp[n][0]=dp[n-1][1] 
        else:
            dp[n][m]= dp[n-1][m-1] + dp[n-1][m+1]

# 테스트 케이스 입력 처리
t = int(input())
total = 0 
for i in range(0, 10):
    total += dp[t][i]  # sum에서 total로 변경
print(total % MOD)