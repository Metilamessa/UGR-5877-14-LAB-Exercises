t = int(input())
for _ in range(t):
    s, k = list(map(int, input().split()))
    
    res = "" 
    
    for i in range(s):
        res += chr(97 + i % k)
    print(res)