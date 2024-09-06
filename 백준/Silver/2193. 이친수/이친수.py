N = int(input())
if N == 1:
    print(1)

else: 
    # DP 테이블 생성
    dp = [0] * (N + 1)
    
    # 초기값 설정
    dp[1] = 1 
    dp[2] = 1

    # 점화식에 따른 DP 계산
    for i in range(3, N + 1):
        dp[i] = dp[i - 2] + dp[i - 1]
    # N자리 이친수의 개수
    print(dp[N])