import sys
from collections import deque

if __name__ == "__main__":
    m, n = map(int, sys.stdin.readline().strip().split())
    visited = [[False] * (m + 1) for i in range(n)]

    dir_x = [1, 0, -1, 0]
    dir_y = [0, 1, 0, -1]

    graph = []
    for i in range(n):
        graph.append(sys.stdin.readline().strip())

    stack = deque()
    white_cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 'W' and not visited[i][j]:
                stack.append([i, j])
                visited[i][j] = True
                tmp_cnt = 1
                while stack:
                    cur = stack.pop()
                    cur_x = cur[0]
                    cur_y = cur[1]
                    for k in range(4):
                        new_x = cur_x + dir_x[k]
                        new_y = cur_y + dir_y[k]

                        if 0 <= new_x < n and 0 <= new_y < m and graph[new_x][new_y] == 'W' and not visited[new_x][
                            new_y]:
                            visited[new_x][new_y] = True
                            tmp_cnt += 1
                            stack.append([new_x, new_y])
                white_cnt += tmp_cnt * tmp_cnt

    blue_cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 'B' and not visited[i][j]:
                stack.append([i, j])
                visited[i][j] = True
                tmp_cnt = 1
                while stack:
                    cur = stack.pop()
                    cur_x = cur[0]
                    cur_y = cur[1]
                    for k in range(4):
                        new_x = cur_x + dir_x[k]
                        new_y = cur_y + dir_y[k]

                        if 0 <= new_x < n and 0 <= new_y < m and graph[new_x][new_y] == 'B' and not visited[new_x][
                            new_y]:
                            visited[new_x][new_y] = True
                            tmp_cnt += 1
                            stack.append([new_x, new_y])
                blue_cnt += tmp_cnt * tmp_cnt
    print(white_cnt, blue_cnt)
