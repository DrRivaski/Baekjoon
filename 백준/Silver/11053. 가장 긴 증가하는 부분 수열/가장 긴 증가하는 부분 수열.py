import sys

if __name__ == "__main__":
    dp = []
    n = int(sys.stdin.readline().strip())
    nums_arr = sys.stdin.readline().strip().split()
    nums_dict = {}
    i = 1
    for num in nums_arr:
        nums_dict[i] = int(num)
        i += 1

    dp.append(0)
    dp.append(1)

    for i in range(2, n + 1):
        index = 0
        maximum = 0
        for j in range(i - 1, 0, -1):
            if nums_dict[j] < nums_dict[i]:
                if dp[j] > maximum:
                    maximum = dp[j]
                    index = j
        dp.append(dp[index] + 1)

    print(max(dp))
