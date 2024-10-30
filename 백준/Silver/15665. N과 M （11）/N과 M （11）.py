n, m = map(int, input().split())
numbers = list(map(int, input().split())) 
numbers.sort()

s=[]

def dfs():
    if len(s)==m:
        print(*s)
        return
    prev = 0
    for i in range(n):
        if numbers[i] != prev:
            s.append(numbers[i])
            dfs()
            s.pop()
            prev = numbers[i]
dfs()