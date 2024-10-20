import sys
n = int(input())
A = list(map(int, sys.stdin.readline().split()))
answer = [-1] * n #초기화
stack = []
stack.append(0)
for i in range(1, n): 
    while stack and A[stack[-1]] < A[i]: #아직 안 구한 인덱스의 숫자와 i번째 숫자를 비교
        answer[stack.pop()] = A[i] #오큰수 구한 인덱스는 pop하고 구한 오큰수를 answer에 집어넣기 
    stack.append(i) #다음 구해야 할 인덱스 집어넣기
print(*answer)