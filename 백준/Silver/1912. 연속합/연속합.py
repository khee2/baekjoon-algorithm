import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))

# 초기값 설정
max_sum = -float('inf')  # 가능한 최소값으로 초기화
current_sum = 0

for num in array:
    current_sum += num  # 현재까지의 합을 갱신
    if current_sum > max_sum:
        max_sum = current_sum  # 최대 합 업데이트
    if current_sum < 0:
        current_sum = 0  # 현재 합이 음수면 초기화

print(max_sum)