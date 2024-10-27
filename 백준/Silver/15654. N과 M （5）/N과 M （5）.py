from itertools import permutations

# 입력 받기
n, m = map(int, input().split())
numbers = sorted(map(int, input().split()))  # 정렬된 리스트 생성

# 모든 경우의 수 생성 및 출력
for seq in permutations(numbers, m):
    print(' '.join(map(str, seq)))