import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    m = int(sys.stdin.readline().strip())
    light_list = list(map(int, sys.stdin.readline().strip().split()))

    first = light_list[0]
    last = n - light_list[-1]

    maximum = 0
    for i in range(len(light_list) - 1):
        distance = light_list[i + 1] - light_list[i]
        if maximum < distance:
            maximum = distance
    if maximum % 2 == 0:
        maximum = int(maximum / 2)
    else:
        maximum = int(maximum / 2) + 1

    answer = max(first, last, maximum)
    print(answer)
