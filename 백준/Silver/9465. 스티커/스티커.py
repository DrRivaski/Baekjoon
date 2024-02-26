import sys

if __name__ == "__main__":
    t = int(sys.stdin.readline().strip())

    for i in range(t):
        n = int(sys.stdin.readline().strip())
        table = []

        if n == 1:
            score1 = int(sys.stdin.readline().strip())
            score2 = int(sys.stdin.readline().strip())
            print(max(score1, score2))
            continue

        for j in range(2):
            table.append(list(map(int, sys.stdin.readline().strip().split())))
        dp = [[0] * n for j in range(2)]
        dp[0][0] = table[0][0]
        dp[1][0] = table[1][0]
        dp[0][1] = dp[1][0] + table[0][1]
        dp[1][1] = dp[0][0] + table[1][1]

        for j in range(2, n):
            dp[0][j] = table[0][j] + max(dp[1][j - 1], dp[0][j - 2], dp[1][j - 2])
            dp[1][j] = table[1][j] + max(dp[0][j - 1], dp[0][j - 2], dp[1][j - 2])

        print(max(dp[0][n - 1], dp[1][n - 1]))
