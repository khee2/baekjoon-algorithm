n, m = map(int, input().split())
numbers = list(map(int, input().split())) 
numbers.sort()

s=[]
visited = [False] * n

def dfs():
    if len(s)==m:
        print(*s)
        return
    prev = 0
    for i in range(n):
        if not visited[i] and numbers[i] != prev:
            visited[i] = True
            s.append(numbers[i])
            dfs()
            s.pop()
            visited[i] = False
            prev = numbers[i]
dfs()