n = int(input())
a = list(map(int, input().split())) 
a.sort()

s = []
visited = [False] * (n+1)
max_sum = 0

def dfs():
    global max_sum
    if len(s)==n:
        max_sum = max(max_sum, sum(abs(s[j] - s[j + 1]) for j in range(n - 1)))
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            s.append(a[i])
            dfs()
            s.pop()
            visited[i] = False
dfs()

print(max_sum)