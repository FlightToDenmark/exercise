testCase = int(input())
MOD = 1000000007

cache = [-1] * 101

def tiling(n):
    if n == 0 or n == 1:
        return 1

    if cache[n] != -1:
        return cache[n]
    
    cache[n] = (tiling(n - 1) + tiling(n - 2)) % MOD
    return cache[n]

for i in range(testCase):
    n = int(input())
    print(tiling(n))
