import sys
input = sys.stdin.readline

N = int(input())  # 수열의 크기 N
A = list(map(int, input().split()))  # 수열 A

# DP 테이블 생성
dp = [1] * N  # 자기 자신만 포함하는 경우 길이는 1로 초기화
previous = [-1] * N  # 각 요소의 이전 요소 인덱스를 저장

# DP 계산
for i in range(1, N):
    for j in range(i):
        if A[i] > A[j]:  # A[i]가 A[j]보다 크면
            if dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1
                previous[i] = j  # 현재 i의 이전 요소를 j로 설정

# 가장 긴 증가하는 부분 수열의 길이
max_length = max(dp)
print(max_length)

# 가장 긴 증가하는 부분 수열을 재구성
lis = []
index = dp.index(max_length)

while index != -1:
    lis.append(A[index])
    index = previous[index]

# 증가하는 부분 수열을 역순으로 정렬
lis.reverse()

print(*lis)  # 그 수열을 출력