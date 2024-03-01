import sys

if __name__ == "__main__":
    n, k = map(int, sys.stdin.readline().strip().split())
    num_list = list(map(int, sys.stdin.readline().strip().split()))

    cnt_dict = {}
    for num in num_list:
        cnt_dict[num] = 0

    left = 0
    right = 0
    answer_list = []

    while right < len(num_list):
        cur_num = num_list[right]
        cnt_dict[cur_num] += 1
        if cnt_dict[cur_num] > k:
            answer_list.append(right - left)
            while cnt_dict[cur_num] > k:
                cnt_dict[num_list[left]] -= 1
                left += 1
        right += 1
        if right == n:
            answer_list.append(right - left)
    print(max(answer_list))
