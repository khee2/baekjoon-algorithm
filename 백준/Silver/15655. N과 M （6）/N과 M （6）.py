n, m = map(int, input().split())
numbers = list(map(int, input().split())) 
numbers.sort()

s=[]
def dfs(start):
    if len(s)==m:
        print(' '.join(map(str,s)))
        return
    
    for i in range(start,n+1):
        if numbers[i-1] not in s:
            s.append(numbers[i-1])
            dfs(i+1)
            s.pop()
dfs(1)