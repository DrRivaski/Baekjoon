def solution(n, money):
    answer = 0
    dp = [1]
    for i in range(n):
        dp.append(0)
    
    for m in money:
        for i in range(m, n + 1):
            dp[i] += dp[i - m] % 1000000007
    
    
    return dp[n]