import math

T = int(input())
for _ in range(T):
    M, N, x, y = map(int, input().split())
    
    # M과 N의 최소공배수 구하기
    lcm = M * N // math.gcd(M, N)
    
    i = x  # i를 x로 초기화
    while i <= lcm:  # i의 범위는 최소공배수를 넘을 수 없다.
        # i가 x와 y 모두의 조건을 만족하는지 확인
        if (i - x) % M == 0 and (i - y) % N == 0: 
            print(i)
            break
        i += M  # M씩 증가
    else:
        print(-1)