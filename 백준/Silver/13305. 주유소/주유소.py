import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    distance = list(map(int, sys.stdin.readline().strip().split()))
    distance.append(0)
    oil = list(map(int, sys.stdin.readline().strip().split()))

    total_price = 0
    min_oil = oil[0]
    cur_distance = distance[0]
    for i in range(n - 1):
        next_oil = oil[i + 1]

        if min_oil > next_oil:
            total_price += min_oil * cur_distance
            min_oil = next_oil
            cur_distance = distance[i + 1]
        else:
            cur_distance += distance[i + 1]

    if cur_distance != 0:
        total_price += min_oil * cur_distance

    print(total_price)
