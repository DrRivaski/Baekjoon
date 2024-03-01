import sys

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().split())

    fuel_table = {}
    for i in range(1, n + 1):
        fuel_table[i] = list(map(int, sys.stdin.readline().strip().split()))

    dp = {}
    for i in range(1, n + 1):
        dp[i] = [[float("inf"), float("inf"), float("inf")]]
        dp[i] += [[0, 0, 0] for j in range(m)]
        dp[i].append([float("inf"), float("inf"), float("inf")])

    for i in range(1, m + 1):
        for j in range(3):
            dp[1][i][j] = fuel_table[1][i - 1]

    for i in range(2, n + 1):
        for j in range(1, m + 1):
            dp[i][j][0] = min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + fuel_table[i][j - 1]
            dp[i][j][1] = min(dp[i - 1][j][0], dp[i - 1][j][2]) + fuel_table[i][j - 1]
            dp[i][j][2] = min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + fuel_table[i][j - 1]

    answer_list = []
    for lst in dp[n]:
        for num in lst:
            answer_list.append(num)

    print(min(answer_list))
