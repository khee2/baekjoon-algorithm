n, m = map(int, input().split())
numbers = list(map(int, input().split())) 
numbers.sort()

s=[]

def dfs(start):
    if len(s)==m:
        print(*s)
        return
    prev = 0
    for i in range(start, n):
        if numbers[i] != prev:
            s.append(numbers[i])
            dfs(i)
            s.pop()
            prev = numbers[i]
dfs(0)