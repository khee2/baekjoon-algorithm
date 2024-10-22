target = int(input())
m = int(input())
if m: # 고장난게 있을 경우만 인풋 받기 (m=0인 경우 제외)
    broken = set(input().split())
else:
    broken = set()
result = abs(100 - target) # ++ or -- 로 이동할 경우의 최댓값

for num in range(1000001):
    # n안에 broken된 채널 번호가 포함되어 있는지 확인
    for n in str(num):
        if (n in broken):
            break
    else: # 번호를 누를 수 있는 경우
        # 특정 번호를 누른 상태에서 target까지 남은 번호 만큼을 구하고, 누른 번호의 길이까지 더해줘야 몇번 눌렀는지 알 수 있다. 
        result = min(result, abs(num - target) + len(str(num)))

print(result)