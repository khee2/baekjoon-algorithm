n, m = map(int, input().split())
numbers = list(map(int, input().split())) 
numbers.sort()

s=[]
def dfs(start):
    if len(s)==m:
        print(*s)
        return
    
    for i in range(start, n+1):
        s.append(numbers[i-1])
        dfs(i)
        s.pop()
dfs(1)