n = int(input()) 
l = len(str(n))   
result = 0       

# l보다 작은 길이의 숫자들의 자릿수 계산
for i in range(1, l):
    result += i * 9 * 10 ** (i-1)

# l 길이의 숫자들의 자릿수 계산
result += (n - 10**(l-1) + 1) * l

print(result)