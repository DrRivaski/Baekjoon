import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline())

    nums_dict = {}
    dp = []

    num_arr = sys.stdin.readline().strip().split()

    i = 0
    for num in num_arr:
        nums_dict[i] = int(num)
        i += 1

    dp.append(nums_dict[0])
    for i in range(1, n):
        dp.append(max(dp[i - 1] + nums_dict[i], nums_dict[i]))

    print(max(dp))
