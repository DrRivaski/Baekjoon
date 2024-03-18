import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    people_list = list(map(int, sys.stdin.readline().strip().split()))
    answer_list = [-1 for i in range(n)]

    idx = 0
    for idx in range(0, n):
        cnt = 0
        target = people_list[idx]

        for i in range(n):
            if cnt == target:
                if answer_list[i] == -1:
                    answer_list[i] = idx + 1
                    break
            if answer_list[i] == -1:
                cnt += 1
    for num in answer_list:
        print(num, end=" ")
