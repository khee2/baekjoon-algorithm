n, m = map(int, input().split())
numbers = list(map(int, input().split())) 
numbers.sort()

s=[]
def dfs():
    if len(s)==m:
        print(' '.join(map(str,s)))
        return
    
    for i in range(1, n+1):
        s.append(numbers[i-1])
        dfs()
        s.pop()
dfs()