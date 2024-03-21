import sys
from collections import deque
import heapq


def initialize_graph(n):
    graph = []
    for i in range(n):
        graph.append(list(map(int, sys.stdin.readline().strip().split())))
    return graph


def initialize_distance_graph(graph, n):
    distance_graph = [[float("inf") for i in range(n)] for j in range(n)]
    distance_graph[0][0] = graph[0][0]
    return distance_graph


if __name__ == "__main__":
    dir_x = [1, 0, -1, 0]
    dir_y = [0, 1, 0, -1]
    try_cnt = 0
    while True:
        try_cnt += 1
        n = int(sys.stdin.readline().strip())

        if n == 0:
            break

        graph = initialize_graph(n)
        distance_graph = initialize_distance_graph(graph, n)

        queue = [(0, [0, 0])]
        while queue:
            cur = heapq.heappop(queue)
            cur_x = cur[1][0]
            cur_y = cur[1][1]

            for i in range(4):
                new_x = cur_x + dir_x[i]
                new_y = cur_y + dir_y[i]

                if 0 <= new_x < n and 0 <= new_y < n and distance_graph[new_x][new_y] > distance_graph[cur_x][cur_y] + \
                        graph[new_x][new_y]:
                    distance_graph[new_x][new_y] = distance_graph[cur_x][cur_y] + graph[new_x][new_y]
                    heapq.heappush(queue, (distance_graph[new_x][new_y], [new_x, new_y]))
        sys.stdout.write("Problem " + str(try_cnt) + ": " + str(distance_graph[n - 1][n - 1]) + "\n")
