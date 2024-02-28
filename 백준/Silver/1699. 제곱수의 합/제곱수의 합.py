import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    dp = [i for i in range(100001)]
    # i = 1
    # while i * i < 100001:
    #     dp[i * i] = 1
    #     i += 1

    for i in range(1, n + 1):
        for j in range(1, i):
            if j * j > i:
                break
            if dp[i] > dp[i - j * j] + 1:
                dp[i] = dp[i - j * j] + 1
    print(dp[n])
