import sys
from collections import deque

if __name__ == "__main__":
    n, k = map(int, sys.stdin.readline().strip().split())
    visited = [False] * 100001
    second = [float("inf")] * 1000001
    second[n] = 0
    walk = [1, -1]
    queue = deque()
    queue.append(n)
    visited[n] = True

    while queue:
        start = queue.popleft()

        for i in walk:
            new_pos = start + i
            if 0 <= new_pos <= 100000 and second[new_pos] > second[start] + 1:
                queue.append(new_pos)
                second[new_pos] = second[start] + 1

        new_pos = start * 2
        if 0 <= new_pos <= 100000 and second[new_pos] > second[start]:
            queue.append(new_pos)
            second[new_pos] = second[start]
    print(second[k])
