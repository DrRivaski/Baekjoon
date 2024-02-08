import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    stairs = {}
    for i in range(n):
        stairs[i + 1] = int(sys.stdin.readline().strip())

    if n == 1:
        print(stairs[n])
    else:
        dp = {}
        for i in range(n):
            dp[i + 1] = [0, 0, 0]

        dp[1][1] = stairs[1]
        dp[1][2] = 0
        dp[2][1] = stairs[2]
        dp[2][2] = stairs[1] + stairs[2]

        for i in range(3, n + 1):
            dp[i][1] = max(dp[i - 2][1], dp[i - 2][2]) + stairs[i]
            dp[i][2] = dp[i - 1][1] + stairs[i]

        print(max(dp[n][1], dp[n][2]))
