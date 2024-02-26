import sys

if __name__ == "__main__":
    t = int(sys.stdin.readline().strip())
    dp = []
    dp.append(0)
    dp.append(1)
    dp.append(2)
    dp.append(4)
    for i in range(4, 1000001):
        dp.append((dp[i - 1] % 1000000009 + dp[i - 2] % 1000000009 + dp[i - 3] % 1000000009) % 1000000009)

    for i in range(t):
        n = int(sys.stdin.readline().strip())
        print(dp[n])
