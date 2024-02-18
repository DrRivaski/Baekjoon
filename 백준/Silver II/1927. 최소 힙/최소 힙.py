import sys
import heapq

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())

    num_list = []
    for i in range(n):
        new_num = int(sys.stdin.readline().strip())
        if new_num == 0:
            if len(num_list) != 0:
                sys.stdout.write(str(heapq.heappop(num_list)) + "\n")
            else:
                sys.stdout.write(str(0) + "\n")
        else:
            heapq.heappush(num_list, new_num)
