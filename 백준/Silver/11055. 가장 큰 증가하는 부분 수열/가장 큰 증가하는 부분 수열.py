import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())

    dp = []
    nums = {}

    nums_arr = sys.stdin.readline().strip().split()

    i = 1
    for num in nums_arr:
        nums[i] = int(num)
        i += 1

    dp.append(0)
    dp.append(nums[1])

    for i in range(2, n + 1):
        index = 0
        maximum = 0
        for j in range(i - 1, 0, -1):
            if nums[j] < nums[i]:
                if dp[j] > maximum:
                    maximum = dp[j]
                    index = j
        dp.append(dp[index] + nums[i])
    print(max(dp))
