import sys

dp = {}
num = {}

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().strip().split())
    num_arr = sys.stdin.readline().strip().split()

    i = 1
    for number in num_arr:
        num[i] = int(number)
        i += 1

    dp[0] = 0
    dp[1] = num[1]
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + num[i]

    for i in range(m):
        j, k = map(int, sys.stdin.readline().strip().split())
        print(dp[k] - dp[j - 1])
