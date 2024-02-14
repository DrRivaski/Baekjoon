import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())

    color_table = {}
    for i in range(n):
        color_table[i] = sys.stdin.readline().strip().split()

    for i in range(n):
        for j in range(3):
            color_table[i][j] = int(color_table[i][j])

    dp = {}
    for i in range(n):
        dp[i] = [0 for j in range(3)]

    dp[0][0] = color_table[0][0]
    dp[0][1] = color_table[0][1]
    dp[0][2] = color_table[0][2]

    for i in range(1, n):
        for j in range(3):
            dp[i][j] = min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + color_table[i][j]

    print(min(dp[n - 1]))
