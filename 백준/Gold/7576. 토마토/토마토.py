import sys
from collections import deque


def initialize_graph(n):
    graph = {}
    for i in range(n):
        graph[i] = list(map(int, sys.stdin.readline().strip().split()))

    return graph


# 모든 토마토가 익었다면 True
def check_graph(n, m, graph):
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                return False
    return True


def find_start_point(n, m, graph):
    start_points = []
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                start_points.append([i, j])
    return start_points


if __name__ == "__main__":
    m, n = map(int, sys.stdin.readline().strip().split())
    graph = initialize_graph(n)

    days = 0
    start_points = find_start_point(n, m, graph)

    dir_x = [1, 0, -1, 0]
    dir_y = [0, 1, 0, -1]

    visited = [[False] * m for i in range(n)]

    while start_points:
        queue = deque()
        tmp_start_points = []
        for start_point in start_points:
            queue.append(start_point)
            visited[start_point[0]][start_point[1]] = True

        while queue:
            cur = queue.popleft()
            cur_x = cur[0]
            cur_y = cur[1]

            for i in range(4):
                new_x = cur_x + dir_x[i]
                new_y = cur_y + dir_y[i]

                if 0 <= new_x < n and 0 <= new_y < m and graph[new_x][new_y] == 0 and not visited[new_x][new_y]:
                    visited[new_x][new_y] = True
                    graph[new_x][new_y] = 1
                    tmp_start_points.append([new_x, new_y])
        if len(tmp_start_points) != 0:
            days += 1
        start_points = tmp_start_points

    if check_graph(n, m, graph):
        print(days)
    else:
        print(-1)
