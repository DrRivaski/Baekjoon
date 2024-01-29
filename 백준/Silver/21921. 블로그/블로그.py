import sys

input = sys.stdin.readline

if __name__ == '__main__':
    N, X = map(int, input().split())
    maximum = 0
    cnt_list = input().strip().split(" ")

    cnt_dict = {}
    for i in range(N):
        cnt_dict[i] = int(cnt_list[i])

    start_cnt = 0
    for i in range(X):
        start_cnt += cnt_dict[i]
        maximum += cnt_dict[i]

    day_cnt = 0
    calculated_cnt_dict = {0: maximum}

    for i in range(1, N - X + 1):
        next_cnt = start_cnt - cnt_dict[i - 1] + cnt_dict[i + X - 1]
        if next_cnt >= maximum:
            calculated_cnt_dict[i] = next_cnt
            maximum = next_cnt
        start_cnt = next_cnt

    if maximum == 0:
        print("SAD", end="")
    else:
        for i in calculated_cnt_dict:
            if calculated_cnt_dict[i] == maximum:
                day_cnt += 1
        print(maximum)
        print(day_cnt, end="")
