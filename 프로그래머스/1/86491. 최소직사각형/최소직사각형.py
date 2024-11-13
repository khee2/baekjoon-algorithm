def solution(sizes): #[[60, 50], [30, 70], [60, 30], [80, 40]]	
    a=[]
    b=[]
    for i in sizes:
        a.append(max(i)) #60, 70, 60, 80
        b.append(min(i)) #50, 30, 30, 40 
    return max(a)*max(b) #80 * 50 