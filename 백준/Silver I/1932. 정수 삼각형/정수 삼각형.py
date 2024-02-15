import sys

input = sys.stdin.readline

triangle = {}
dp = {}


def initialize_triangle(n):
    for i in range(n):
        tmp_list = input().strip().split()
        for j in range(i + 1):
            tmp_list[j] = int(tmp_list[j])
        triangle[i + 1] = tmp_list


def initialize_dp(n):
    for i in range(n):
        dp[i + 1] = [0 for j in range(i + 1)]

    dp[1][0] = triangle[1][0]

    for i in range(1, n):
        dp[i + 1][0] = dp[i][0] + triangle[i + 1][0]

    for i in range(1, n):
        dp[i + 1][-1] = dp[i][-1] + triangle[i + 1][-1]


if __name__ == "__main__":
    n = int(input().strip())
    initialize_triangle(n)
    initialize_dp(n)

    for i in range(3, n + 1):
        for j in range(1, i - 1):
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]

    print(max(dp[n]))
