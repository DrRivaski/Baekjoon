import sys


def solution(n, idx):
    table = [[0, 0, 0]]
    dp = [[0, 0, 0] for i in range(n + 1)]

    for i in range(n):
        table.append(list(map(int, sys.stdin.readline().strip().split())))
    dp[1][0] = table[1][0]
    dp[1][1] = table[1][1]
    dp[1][2] = table[1][1] + table[1][2]
    dp[2][0] = dp[1][1] + table[2][0]
    dp[2][1] = min(dp[2][0], dp[1][1], dp[1][2]) + table[2][1]
    dp[2][2] = min(dp[2][1], dp[1][1], dp[1][2]) + table[2][2]
    for i in range(3, n + 1):
        dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + table[i][0]
        dp[i][1] = min(dp[i][0], dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + table[i][1]
        dp[i][2] = min(dp[i][1], dp[i - 1][1], dp[i - 1][2]) + table[i][2]
    print(idx, end=". ")
    print(dp[n][1])


if __name__ == "__main__":
    idx = 1
    while True:
        n = int(sys.stdin.readline().strip())
        if n == 0:
            break
        solution(n, idx)
        idx += 1
