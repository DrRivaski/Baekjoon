import sys

if __name__ == "__main__":
    n, k = map(int, sys.stdin.readline().strip().split())
    dp = [1]
    for i in range(k):
        dp.append(0)

    money = []
    for i in range(n):
        money.append(int(sys.stdin.readline().strip()))

    for m in money:
        for i in range(m, k + 1):
            dp[i] += dp[i - m]
    print(dp[k])
