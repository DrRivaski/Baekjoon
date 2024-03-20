import sys

if __name__ == "__main__":
    t = int(sys.stdin.readline().strip())

    for i in range(t):
        n = int(sys.stdin.readline().strip())
        money = list(map(int, sys.stdin.readline().strip().split()))

        k = int(sys.stdin.readline().strip())
        dp = [1]
        for j in range(k):
            dp.append(0)

        for m in money:
            for j in range(m, k + 1):
                dp[j] += dp[j - m]
        print(dp[k])
