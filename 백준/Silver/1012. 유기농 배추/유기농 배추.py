import sys
from collections import deque


def initialize_graph(m, n, k):
    graph = [[0] * m for i in range(n)]
    for i in range(k):
        u, v = map(int, sys.stdin.readline().strip().split())
        graph[v][u] = 1
    return graph


if __name__ == "__main__":
    t = int(sys.stdin.readline().strip())
    dir_x = [1, 0, -1, 0]
    dir_y = [0, 1, 0, -1]

    for i in range(t):
        answer = 0
        m, n, k = map(int, sys.stdin.readline().strip().split())
        graph = initialize_graph(m, n, k)
        visited = [[False] * m for j in range(n)]
        for idx1 in range(n):
            for idx2 in range(m):
                if graph[idx1][idx2] == 1 and not visited[idx1][idx2]:
                    queue = deque()
                    queue.append([idx1, idx2])
                    visited[idx1][idx2] = True

                    while queue:
                        cur = queue.popleft()
                        cur_x = cur[0]
                        cur_y = cur[1]

                        for dir_idx in range(4):
                            new_x = cur_x + dir_x[dir_idx]
                            new_y = cur_y + dir_y[dir_idx]
                            if 0 <= new_x < n and 0 <= new_y < m and not visited[new_x][new_y] and graph[new_x][new_y] == 1:
                                visited[new_x][new_y] = True
                                graph[new_x][new_y] = 0
                                queue.append([new_x, new_y])
                    answer += 1
        print(answer)
