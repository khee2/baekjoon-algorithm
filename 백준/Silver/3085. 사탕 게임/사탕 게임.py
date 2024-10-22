def max_candy(board, n):
    max_count = 1 
    for i in range(n):
        row_count = 1
        col_count = 1
        for j in range(1, n):
            # 행 max 확인
            if board[i][j] == board[i][j-1]:
                row_count+=1
            else:
                row_count = 1
            max_count = max(max_count, row_count)
            
            # 열 max 확인
            if board[j][i] == board[j - 1][i]:
                col_count += 1
            else:
                col_count = 1
            max_count = max(max_count, col_count)
        
    return max_count


n = int(input())
board = [list(input()) for _ in range(n)]
result = 0

for i in range(n):
    for j in range(n):
        # 아래쪽 사탕과 색상이 다르면 (아래쪽 사탕이 없으면 비교x)
        if j+1 < n and board[i][j] != board[i][j+1]:
            # 두 사탕 교환
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j] # swap
            # 행과 열을 확인해 같은 색상이 연속된 최대 길이를 업데이트
            result = max(result, max_candy(board, n))
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j] # 원상복구
            
        # 오른쪽 사탕과 색상이 다르면 (오른쪽에 사탕이 없으면 비교x)
        if i+1 < n and board[i][j] != board[i+1][j]:
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
            result = max(result, max_candy(board, n))
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j] # 원상복구
print(result)