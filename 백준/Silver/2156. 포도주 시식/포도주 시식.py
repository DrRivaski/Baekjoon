import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    table = []
    for i in range(n):
        table.append(int(sys.stdin.readline().strip()))

    dp = []
    dp.append(0)
    dp.append(table[0])
    if n > 1:
        dp.append(table[0] + table[1])

    if n > 2:
        for i in range(3, n + 1):
            dp.append(max(table[i - 1] + table[i - 2] + dp[i - 3], table[i - 1] + dp[i - 2], dp[i - 1]))
    print(dp[n])
