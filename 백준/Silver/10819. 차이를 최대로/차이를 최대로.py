n = int(input())
a = list(map(int, input().split())) 
a.sort()

s = []
visited = [False] * (n+1)

final = []

def dfs():
    if len(s)==n:
        final.append(s[:])  # 리스트의 복사본을 추가
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            s.append(a[i])
            dfs()
            s.pop()
            visited[i] = False
dfs()

max_sum = 0

# # final의 모든 요소 출력
# for perm in final:
#     print(*perm)
    
for i in range(len(final)):
    cur_sum = 0
    for j in range(n-1):
        cur_sum += abs(final[i][j] - final[i][j+1])
    max_sum = max(max_sum, cur_sum)

print(max_sum)