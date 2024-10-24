t = int(input())

dp = {1: 1, 2: 2, 3: 4}  # 처음 값들을 딕셔너리로 초기화

for _ in range(t):
    n = int(input())
    
    if n not in dp:
        for j in range(4, n+1):
            if j not in dp:  # 아직 dp[j]가 계산되지 않은 경우
                dp[j] = 0  # dp[j]를 0으로 초기화
                for k in range(1, 4):  # 1, 2, 3의 합으로 dp[j] 값 계산
                    dp[j] += dp[j - k]
    
    # dp[n] 출력
    print(dp[n])