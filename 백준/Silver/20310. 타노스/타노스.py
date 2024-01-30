import sys


def count_one(S):
    cnt = 0
    for s in S:
        if s == "1":
            cnt += 1
    return cnt


def count_zero(S):
    cnt = 0
    for s in S:
        if s == "0":
            cnt += 1
    return cnt


if __name__ == "__main__":
    S = sys.stdin.readline().strip()
    half_one = int(count_one(S) / 2)
    half_zero = int(count_zero(S) / 2)

    S_in_list = list(S)

    for i in range(half_one):
        S_in_list.remove("1")

    S_in_list.reverse()
    for i in range(half_zero):
        S_in_list.remove("0")

    S_in_list.reverse()

    result = ""
    for s in S_in_list:
        result += s
    print(result)
