if __name__ == "__main__":
    n = int(input())
    dp = [1, 3]
    for i in range(2, n + 1):
        dp.append((dp[i - 2] + 2 * dp[i - 1]) % 9901)

    print(dp[n])
