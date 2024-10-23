T = int(input())
for _ in range(T):
    M, N, x, y = map(int, input().split())
    
    i = x  # k를 x로 초기화
    while i <= M * N:  # k의 범위는 M*N을 넘을 수 없기에
        if (i - x) % M == 0 and (i - y) % N == 0:
            print(i)
            break
        i += M  # x를 기준으로 M씩 증가시켜 확인
    else:
        print(-1)