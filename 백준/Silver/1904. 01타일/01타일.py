import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    tmp1 = 1
    tmp2 = 2
    answer = 0
    if n == 1:
        answer = 1
    if n == 2:
        answer = 2

    for i in range(3, n + 1):
        answer = (tmp1 % 15746 + tmp2 % 15746) % 15746
        tmp1 = tmp2
        tmp2 = answer

    print(answer)
