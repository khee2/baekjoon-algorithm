n = int(input())
numbers = list(map(int, input().split())) 

for i in range(n-1, 0, -1):
    if numbers[i-1] > numbers[i]: # 뒤보다 앞에가 더 큰 경우 (내림차순 찾기)
        for j in range(n-1, 0, -1):
            if numbers[i-1] > numbers[j]: # 바꾸려는 값보다 작은 값 찾기
                numbers[i-1], numbers[j] = numbers[j], numbers[i-1] # 바꾸려는 값과 그보다 큰 값을 swap
                numbers = numbers[:i] + sorted(numbers[i:], reverse=True)
                print(*numbers)
                exit()
print(-1)