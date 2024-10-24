def backtrack(n, m, sequence, visited):
    # sequence안에 m개의 요소가 쌓인다면 출력
    if len(sequence) == m:
        print(' '.join(map(str, sequence)))
        return
    
    # 1부터 n까지의 숫자를 하나씩 확인    
    for i in range(1, n+1):
        if not visited[i]:
            # i가 아직 방문되지 않았다면
            visited[i] = True
            sequence.append(i)
            
            # 다음 숫자를 선택하기 위해 재귀 호출
            backtrack(n,m,sequence, visited)
            
            # 선택을 되돌리기 (백트래킹)
            sequence.pop()
            visited[i] = False

n, m = map(int, input().split())

# 방문 여부를 확인하기 위한 리스트
visited = [False] * (n + 1)

# 결과를 담을 스택
sequence = []

backtrack(n, m, sequence, visited)