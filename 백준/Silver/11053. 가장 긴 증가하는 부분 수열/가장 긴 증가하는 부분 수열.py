N = int(input())  # 수열의 크기 N
A = list(map(int, input().split()))  # 수열 A

# DP 테이블 생성
dp = [1] * N  # 자기 자신만 포함하는 경우 길이는 1이므로 1로 초기화

for i in range(1, N):
    for j in range(i):
        if (A[i] > A[j]): 
            dp[i] = max(dp[i], dp[j] + 1) 
print(max(dp))