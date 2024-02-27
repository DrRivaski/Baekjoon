import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    dp = [[1 for i in range(10)]]
    for i in range(1, n):
        dp.append([1])
        for j in range(1, 10):
            result = 0
            for k in range(j + 1):
                result += dp[i - 1][k]
            dp[i].append(result % 10007)
    answer_list = []
    for d in dp:
        answer = 0
        for num in d:
            answer += num
            answer = answer % 10007
        answer_list.append(answer)

    print(answer_list[n - 1])
