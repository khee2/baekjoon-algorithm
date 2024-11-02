n = int(input())

s = []
visited = [False] * (n+1)

def dfs():
    if len(s)==n:
        print(*s)
        return
    
    for i in range(1, n+1):
        if not visited[i]:
            visited[i] = True
            s.append(i)
            dfs()
            s.pop()
            visited[i] = False
dfs()