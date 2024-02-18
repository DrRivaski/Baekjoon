import sys
import heapq

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    num_list = list(map(int, sys.stdin.readline().strip().split()))

    heapq.heapify(num_list)

    for i in range(n - 1):
        tmp_num_list = list(map(int, sys.stdin.readline().strip().split()))
        for number in tmp_num_list:
            if number > num_list[0]:
                heapq.heappop(num_list)
                heapq.heappush(num_list, number)

    print(num_list[0])
