heights = [int(input()) for _ in range(9)]

total_sum = sum(heights)

for i in range(9):
    for j in range(i + 1, 9):
        if total_sum - heights[i] - heights[j] == 100:
            result = [heights[k] for k in range(9) if k != i and k != j]
            result.sort()
            for height in result:
                print(height)
            exit()