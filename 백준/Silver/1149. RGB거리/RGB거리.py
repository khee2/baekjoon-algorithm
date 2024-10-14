n = int(input())  # 집 수
cost = [list(map(int, input().split())) for _ in range(n)]  # 각 집의 색칠 비용

# dp 초기화
dp = [[0] * 3 for _ in range(n)]

# 첫 번째 집의 색칠 비용 초기화
dp[0][0] = cost[0][0]  # 빨강으로 칠한 경우
dp[0][1] = cost[0][1]  # 초록으로 칠한 경우
dp[0][2] = cost[0][2]  # 파랑으로 칠한 경우

# 두 번째 집부터 n번째 집까지의 최소 비용 계산
for i in range(1, n):
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + cost[i][0]  # 현재 집을 빨강으로 칠함
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + cost[i][1]  # 현재 집을 초록으로 칠함
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + cost[i][2]  # 현재 집을 파랑으로 칠함

# 마지막 집의 최소 비용 중 가장 작은 값을 출력
print(min(dp[n-1][0], dp[n-1][1], dp[n-1][2]))