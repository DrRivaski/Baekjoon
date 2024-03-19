import sys

if __name__ == "__main__":
    t = int(sys.stdin.readline().strip())
    dp = []
    dp.append([1, 0])
    dp.append([0, 1])
    
    for i in range(2, 41):
        dp.append([dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]])
    
    for i in range(t):
        n = int(sys.stdin.readline())
        print(dp[n][0], end=" ")
        print(dp[n][1])